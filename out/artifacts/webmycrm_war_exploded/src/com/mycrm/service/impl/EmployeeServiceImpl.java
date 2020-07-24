package com.mycrm.service.impl;

import com.mycrm.dao.EmployeeDao;
import com.mycrm.dao.impl.EmployeeDaoImpl;
import com.mycrm.pojo.Employee;
import com.mycrm.service.EmployeeService;

import java.sql.SQLException;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao empdao = new EmployeeDaoImpl();

    @Override
    public boolean Login1(Employee emp) {
        boolean result = false;

        try {
            Employee realemp = empdao.selectByUsername(emp.getUsername());
            if (realemp != null) {
                if (realemp.getPassword().equals(emp.getPassword())) {
                    result = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public Employee Login(Employee emp) {
        Employee result = null;

        try {
            Employee realemp = empdao.selectByUsername(emp.getUsername());
            if (realemp != null) {
                if (realemp.getPassword().equals(emp.getPassword())) {
                    result = realemp;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
