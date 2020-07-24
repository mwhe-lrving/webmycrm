package com.mycrm.dao.impl;

import com.mycrm.dao.BaseDao;
import com.mycrm.dao.EmployeeDao;
import com.mycrm.pojo.Employee;
import com.mycrm.tools.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl extends BaseDao implements EmployeeDao {
    @Override
    public int insertEmp(Employee emp) throws SQLException {
        String sql = "INSERT INTO `mycrmdb`.`employee`(`realname`, `username`, `password`, `tel`, `email`) VALUES (?, ?, ?, ?, ?)";
        int result =
                super.exeUpdate(sql, emp.getRealname(), emp.getUsername(), emp.getPassword(), emp.getTel(), emp.getEmail());
        return result;
    }

    @Override
    public int updateEmp(Employee emp) throws SQLException {
        String sql = "UPDATE `mycrmdb`.`employee` SET `realname` = ?, `username` =?, `password` = ?, `tel` = ?, `email` = ? WHERE `empid` = ?";
        int result =
                super.exeUpdate(sql, emp.getRealname(), emp.getUsername(), emp.getPassword(), emp.getTel(), emp.getEmail(), emp.getEmpid());
        return result;
    }

    @Override
    public int delEmpById(int id) throws SQLException {
        String sql = "DELETE FROM `mycrmdb`.`employee` WHERE `empid` = ?";
        int result =
                super.exeUpdate(sql, id);
        return result;
    }

    @Override
    public Employee selectById(int id) throws SQLException {
        Employee emp = null;
        String sql = "SELECT * FROM `mycrmdb`.`employee` WHERE `empid` = ?";
        emp = super.exeQueryOne(sql, new EmpRowMapper(), id);
        return emp;
    }

    @Override
    public Employee selectByUsername(String username) throws SQLException {
        Employee emp = null;
        String sql = "SELECT * FROM `mycrmdb`.`employee` WHERE `username` = ?";
        emp = super.exeQueryOne(sql, new EmpRowMapper(), username);

        return emp;
    }

    @Override
    public List<Employee> selectAll() throws SQLException {
        List<Employee> emps = new ArrayList<>();
        String sql = "SELECT * FROM `mycrmdb`.`employee` ORDER BY empid desc";
        emps = super.exeQueryList(sql, new EmpRowMapper());

        return emps;
    }

    class EmpRowMapper implements RowMapper<Employee> {
        @Override
        public Employee makeBean(ResultSet rs) throws SQLException {
            Employee emp = new Employee();
            emp.setEmpid(rs.getInt("empid"));
            emp.setEmail(rs.getString("email"));
            emp.setPassword(rs.getString("password"));
            emp.setRealname(rs.getString("realname"));
            emp.setTel(rs.getString("tel"));
            emp.setUsername(rs.getString("username"));
            return emp;
        }
    }

}
