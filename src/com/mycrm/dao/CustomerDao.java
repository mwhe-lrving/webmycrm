package com.mycrm.dao;

import com.mycrm.pojo.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    public int insertCust(Customer cust) throws SQLException;

    public int updateCust(Customer cust) throws SQLException;

    public int delCustById(int id) throws SQLException;

    public int delMany(Integer[] ids) throws SQLException;

    public Customer selectById(int custid) throws SQLException;

    public Customer selectByName(String custname) throws SQLException;

    public List<Customer> selectAll() throws SQLException;

    public List<Customer> selectByEmp(Customer cust, int pageindex, int pagesize) throws SQLException;

    public int selectCountByCust(Customer cust) throws SQLException;

}
