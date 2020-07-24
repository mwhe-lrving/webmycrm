package com.mycrm.service;

import com.mycrm.pojo.Customer;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

public interface CustomerService {
    public int addCust(Customer cust);

    public int delById(int custid);

    public int editCust(Customer cust);

    public List<Customer> search(Customer cust, int pageindex, int pagesize);

    public int getCountByCust(Customer cust, int pagesize);

    public Customer getCustByid(int custid);
    public int manyDel(String ids[]);

}

