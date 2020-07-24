package com.mycrm.servlet;

import com.alibaba.fastjson.JSONObject;
import com.mycrm.pojo.Customer;
import com.mycrm.pojo.Employee;
import com.mycrm.service.CustomerService;
import com.mycrm.service.impl.CustomerServiceImpl;
import com.mycrm.tools.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/admin/docust")
public class CustomerServlet extends HttpServlet {
//    private CustomerService custService = new CustomerServiceImpl();
    private CustomerService custService = ServiceFactory.createCustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("op");
        if ("doadd".equals(action)) {
            doAdd(request, response);
        } else if ("search".equals(action)) {
            search(request, response);
        } else if ("toedit".equals(action)) {
            toEdit(request, response);
        } else if ("doedit".equals(action)) {
            doEdit(request, response);
        } else if ("dodel".equals(action)) {
            doDel(request, response);
        }else if ("manydel".equals(action)) {
            manyDel(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee emp = (Employee) request.getSession().getAttribute("loginemp");
        String custname = request.getParameter("custname");
        Customer cust = new Customer();
        cust.setCustname(custname);
        cust.setEmpid(emp.getEmpid());
        int pagesize = 2;
        int pageindex = 1;
        String pagestr = request.getParameter("pageindex");
        if (pagestr != null && !"".equals(pagestr)) {
            pageindex = Integer.parseInt(pagestr);
        }
        List<Customer> custs = custService.search(cust, pageindex, pagesize);
        int pagecount = custService.getCountByCust(cust, pagesize);
        request.setAttribute("custs", custs);
        request.setAttribute("condition", cust);
        request.setAttribute("pageindex", pageindex);
        request.setAttribute("pagecount", pagecount);
//        request.getRequestDispatcher("/admin/cust_search.jsp").forward(request, response);
        Map<String, Object> map = new HashMap<>();
        map.put("datas", custs);
        map.put("pagecount", pagecount);
        String jsonstr = JSONObject.toJSONString(map);
        response.getWriter().print(jsonstr);
    }

    protected void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int custid = Integer.parseInt(request.getParameter("custid"));

        Customer cust = custService.getCustByid(custid);
        String jsonString = JSONObject.toJSONString(cust);
        response.getWriter().print(jsonString);

    }

    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String custname = request.getParameter("custname");
        String contacts = request.getParameter("contacts");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        Employee emp = (Employee) request.getSession().getAttribute("loginemp");
        Customer cust = new Customer(custname, contacts, tel, email, emp.getEmpid());
        System.out.println("添加的客户" + cust.toString());
        int result = custService.addCust(cust);
        Map<String, Object> map = new HashMap<>();
        map.put("result", result);
        if (result > 0) {
            //  response.sendRedirect(request.getContextPath() + "/admin/cust_list.html");
            map.put("msg", "添加成功");
        } else if (result == 0) {
            map.put("msg", "添加成功");
            //  response.getWriter().print("<script>alert('添加失败');history.go(-1);</script>");
        } else {
            map.put("msg", "客户已经存在");
            // response.getWriter().print("<script>alert('客户已经存在');history.go(-1);</script>");
        }
        String jsonString = JSONObject.toJSONString(map);
        response.getWriter().print(jsonString);
    }

    protected void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String custname = request.getParameter("custname");
        String contacts = request.getParameter("contacts");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        int custid = Integer.parseInt(request.getParameter("custid"));
        Customer cust = new Customer(custid, custname, contacts, tel, email);

        int result = custService.editCust(cust);
        Map<String, Object> map = new HashMap<>();
        map.put("result", result);

        if (result > 0) {
//            response.sendRedirect(request.getContextPath() + "/admin/cust_list.html");
            map.put("msg", "修改成功!");
        } else if (result == 0) {
//            response.getWriter().print("<script>alert('删除失败');history.go(-1);</script>");
            map.put("msg", "修改失败!");

        } else {
            map.put("msg", "客户名重复，修改失败");
        }
        String jsonString = JSONObject.toJSONString(map);
        response.getWriter().print(jsonString);
    }

    protected void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException {


        int custid = Integer.parseInt(request.getParameter("custid"));

        int result = custService.delById(custid);
        //
        Map<String, Object> map = new HashMap<>();
        map.put("result", result);
        if (result > 0) {
//            response.sendRedirect(request.getContextPath() + "/admin/cust_list.html");
            map.put("msg", "删除成功!");
        } else {
//            response.getWriter().print("<script>alert('删除失败');history.go(-1);</script>");
            map.put("msg", "删除失败!");

        }
        String jsonstr = JSONObject.toJSONString(map);
        response.getWriter().print(jsonstr);
    }

    protected void manyDel(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String[] custids = request.getParameterValues("custids[]");
        String custidsStr=String.join(",",custids);
        System.out.println(custidsStr);
        int result = custService.manyDel(custids);
        //
        Map<String, Object> map = new HashMap<>();
        map.put("result", result);
        if (result > 0) {
//            response.sendRedirect(request.getContextPath() + "/admin/cust_list.html");
            map.put("msg", "删除成功!");
        } else {
//            response.getWriter().print("<script>alert('删除失败');history.go(-1);</script>");
            map.put("msg", "删除失败!");

        }
        String jsonstr = JSONObject.toJSONString(map);
        response.getWriter().print(jsonstr);
    }
}
