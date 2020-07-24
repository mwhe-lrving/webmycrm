package com.mycrm.servlet;

import com.mycrm.pojo.Employee;
import com.mycrm.service.EmployeeService;
import com.mycrm.tools.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/doLogin")
public class LoginServlet extends HttpServlet {
    private EmployeeService service = ServiceFactory.createEmployeeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Employee emp = new Employee();
        emp.setUsername(username);
        emp.setPassword(password);
        Employee realemp = service.Login(emp);
        System.out.println(realemp);
        if (realemp == null) {
            response.getWriter().print("<script>alert('登录失败');history.go(-1);</script>");
        } else {
            request.getSession().setAttribute("loginemp", realemp);
            System.out.println(emp);
            response.sendRedirect(request.getContextPath() + "/admin/index.jsp");
        }
    }
}
