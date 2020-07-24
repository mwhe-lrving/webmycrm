package com.mycrm.dao.impl;

import com.mycrm.dao.BaseDao;
import com.mycrm.dao.CustomerDao;
import com.mycrm.pojo.Customer;
import com.mycrm.tools.RowMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl extends BaseDao implements CustomerDao {
    @Override
    public int insertCust(Customer cust) throws SQLException {
        String sql = "INSERT INTO `mycrmdb`.`customer`(`custname`, `contacts`, `tel`, `email`,`empid`)  VALUES (?, ?, ?, ?, ?)";
        int result = super.exeUpdate(sql, cust.getCustname(), cust.getContacts(), cust.getTel(), cust.getEmail(), cust.getEmpid());
        System.out.println("执行的sql" + sql);
        return result;
    }

    @Override
    public int updateCust(Customer cust) throws SQLException {
        String sql = "UPDATE `mycrmdb`.`customer` SET `custname` = ?, `contacts` = ?, `tel` = ?, `email` = ? WHERE `custid` = ?";
        int result = super.exeUpdate(sql, cust.getCustname(), cust.getContacts(), cust.getTel(), cust.getEmail(), cust.getCustid());

        return result;
    }

    @Override
    public int delCustById(int id) throws SQLException {
        String sql = "DELETE FROM `mycrmdb`.`customer` WHERE `custid` = ?";
        int result = super.exeUpdate(sql, id);

        return result;
    }

    @Override
    public int delMany(Integer[] ids) throws SQLException {
        String sql = "DELETE FROM `mycrmdb`.`customer` WHERE `custid` in (";
        Object values[] = new Object[ids.length];
        for (int i = 0; i < ids.length; i++) {
            if (i == 0) {
                sql += "?";
            } else {
                sql += ",?";
            }
            values[i] = ids[i];
        }
        sql += ")";
        int result = super.exeUpdate(sql, values);

        return result;
    }

    @Override
    public Customer selectById(int custid) throws SQLException {
        Customer cust = null;
        String sql = "SELECT * FROM `mycrmdb`.`customer` WHERE `custid` = ?";
        cust = super.exeQueryOne(sql, new CustRowMapper(), custid);
        return cust;
    }

    @Override
    public Customer selectByName(String custname) throws SQLException {
        Customer cust = null;
        String sql = "SELECT * FROM `mycrmdb`.`customer` WHERE `custname` = ?";
        cust = super.exeQueryOne(sql, new CustRowMapper(), custname);

        return cust;
    }


    @Override
    public List<Customer> selectAll() throws SQLException {
        List<Customer> custs = new ArrayList<>();
        Customer cust = null;
        String sql = "SELECT * FROM `mycrmdb`.`customer` ORDER BY custid desc";
        custs = super.exeQueryList(sql, new CustRowMapper());

        return custs;
    }

    @Override
    public List<Customer> selectByEmp(Customer cust, int pageindex, int pagesize) throws SQLException {
        List<Customer> custs = new ArrayList<>();
        String sql = "SELECT * FROM `mycrmdb`.`customer` WHERE 1=1 ";

        List values = new ArrayList();
        if (cust != null) {
            if (cust.getEmpid() != 0) {
                sql += " and empid=? ";
                values.add(cust.getEmpid());
            }
            if (cust.getCustname() != null && !"".equals(cust.getCustname())) {
                sql += " and custname like ?";
                values.add("%" + cust.getCustname() + "%");

            }
        }
        sql += " ORDER BY custid asc LIMIT ?,?";
        values.add((pageindex - 1) * pagesize);
        values.add(pagesize);
        custs = super.exeQueryList(sql, new CustRowMapper(), values.toArray());
        return custs;
    }

    @Override
    public int selectCountByCust(Customer cust) throws SQLException {
        Integer count = 0;
        System.out.println(Thread.currentThread().getName() + "111111111111111111111111111111111111111");
        String sql = "SELECT COUNT(custid) cust_count FROM `mycrmdb`.`customer` WHERE 1=1 ";
        System.out.println(123);
        List values = new ArrayList();
        if (cust != null) {
            if (cust.getEmpid() != 0) {
                sql += " and empid=? ";
                values.add(cust.getEmpid());
            }
            if (cust.getCustname() != null && !"".equals(cust.getCustname())) {
                sql += " and custname like ?";
                values.add("%" + cust.getCustname() + "%");
            }
        }
        RowMapper<Integer> countRowMapper = new RowMapper<Integer>() {
            @Override
            public Integer makeBean(ResultSet rs) throws SQLException {

                return new Integer(rs.getInt(1));
            }
        };
        count = super.exeQueryOne(sql, countRowMapper, values.toArray());
        return count;
    }

    class CustRowMapper implements RowMapper<Customer> {

        @Override
        public Customer makeBean(ResultSet rs) throws SQLException {
            Customer cust = new Customer();
            cust = new Customer();
            cust.setContacts(rs.getString("contacts"));
            cust.setCustid(rs.getInt("custid"));
            cust.setCustname(rs.getString("custname"));
            cust.setEmail(rs.getString("email"));
            cust.setEmpid(rs.getInt("empid"));
            cust.setTel(rs.getString("tel"));
            return cust;
        }
    }
}
