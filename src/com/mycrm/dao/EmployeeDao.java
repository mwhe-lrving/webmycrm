package com.mycrm.dao;

import com.mycrm.pojo.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    public int insertEmp(Employee emp) throws SQLException;

    public int updateEmp(Employee emp) throws SQLException;

    public int delEmpById(int id) throws SQLException;

    public Employee selectById(int id) throws SQLException;

    public Employee selectByUsername(String username) throws SQLException;

    public List<Employee> selectAll() throws SQLException;

}

