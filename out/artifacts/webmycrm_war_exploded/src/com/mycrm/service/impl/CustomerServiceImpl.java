package com.mycrm.service.impl;

import com.mycrm.dao.CustomerDao;
import com.mycrm.dao.impl.CustomerDaoImpl;
import com.mycrm.pojo.Customer;
import com.mycrm.service.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao dao = new CustomerDaoImpl();
    @Override
    public int addCust(Customer cust) {
        int result = 0;
        try {
            Customer realcust = null;
            realcust = dao.selectByName(cust.getCustname());
            if (realcust == null) {
                result = dao.insertCust(cust);
            } else {
                result = -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delById(int custid) {
        int result = 0;

        try {
            result = dao.delCustById(custid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int editCust(Customer cust) {
        int result = 0;
        try {
            Customer realcust = dao.selectByName(cust.getCustname());
            if (realcust == null) {
                System.out.println("这个名字没有");
                result = dao.updateCust(cust);
            } else {
                if (realcust.getCustid() == cust.getCustid()) {
                    System.out.println("这个名字有，并且ID对的上");
                    result = dao.updateCust(cust);
                } else {
                    System.out.println("这个名字有，但是id对不上");
                    result = -1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Customer> search(Customer cust, int pageindex, int pagesize) {
        List<Customer> custs = null;
        try {
            custs = dao.selectByEmp(cust, pageindex, pagesize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return custs;
    }

    @Override
    public int getCountByCust(Customer cust, int pagesize) {
        int pagecount = 0;
        try {
            int rscount = dao.selectCountByCust(cust);
            if (rscount % pagesize == 0) {
                pagecount = rscount / pagesize;
            } else {
                pagecount = rscount / pagesize + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pagecount;
    }

    @Override
    public Customer getCustByid(int custid) {
        Customer cust = null;

        try {
            cust = dao.selectById(custid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cust;
    }

    @Override
    public int manyDel(String[] ids) {
        int result = 0;

        try {
            Integer[] custids = new Integer[ids.length];
            for (int i = 0; i < custids.length; i++) {
                custids[i] = Integer.parseInt(ids[i]);
                System.out.println(custids[i] + "6666666666666666666666666666666");
            }

            result = dao.delMany(custids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
