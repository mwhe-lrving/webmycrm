package com.mycrm.test;

import com.mycrm.dao.EmployeeDao;
import com.mycrm.dao.impl.EmployeeDaoImpl;
import com.mycrm.pojo.Employee;
import com.mycrm.tools.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class EmpTest {
    public static void main(String[] args) {
//        EmployeeDao employeeDao = new EmployeeDaoImpl();
//     //   Connection conn = JdbcUtils.createConn();
//        try {
//            List<Employee> employees = employeeDao.selectAll(conn);
//            for (int i = 0; i < employees.size(); i++) {
//                System.out.println(employees.get(i));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            JdbcUtils.closeALL(conn);
//        }
    }
}
