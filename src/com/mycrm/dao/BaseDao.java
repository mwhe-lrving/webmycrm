package com.mycrm.dao;

import com.mycrm.tools.JdbcUtils;
import com.mycrm.tools.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {
    //通用增删改
    public int exeUpdate(String sql, Object... values) throws SQLException {
        int result = 0;
        Connection conn = JdbcUtils.getConn();
        PreparedStatement pstms = conn.prepareStatement(sql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                System.out.println("BaseDao->value[]=" + values[i]);
                pstms.setObject(i + 1, values[i]);
            }
        }
        result = pstms.executeUpdate();
        return result;
    }

    public ResultSet exeQuery(String sql, Object... values) throws SQLException {
        ResultSet result = null;
        Connection conn = JdbcUtils.getConn();
        PreparedStatement pstms = conn.prepareStatement(sql);
        System.out.println(sql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                pstms.setObject(i + 1, values[i]);
            }
        }
        result = pstms.executeQuery();
        return result;
    }

    public <T> T exeQueryOne(String sql, RowMapper<T> mapper, Object... values) throws SQLException {
        T t = null;
        ResultSet rs = null;
        Connection conn = JdbcUtils.getConn();
        PreparedStatement pstms = conn.prepareStatement(sql);
        System.out.println(sql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                pstms.setObject(i + 1, values[i]);
            }
        }
        rs = pstms.executeQuery();
        if (rs.next()) {
            t = mapper.makeBean(rs);
        }

        return t;
    }

    public <T> List<T> exeQueryList(String sql, RowMapper<T> mapper, Object... values) throws SQLException {
        List<T> items = new ArrayList<T>();
        ResultSet rs = null;
        Connection conn = JdbcUtils.getConn();
        PreparedStatement pstms = conn.prepareStatement(sql);
        System.out.println("exeQueryList" + sql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                pstms.setObject(i + 1, values[i]);
            }
        }
        rs = pstms.executeQuery();
        while (rs.next()) {
            T t = mapper.makeBean(rs);
            items.add(t);
        }

        return items;
    }

    public int executeUpdate(String sql, Object[] values) throws SQLException {
        int result = 0;
        Connection conn = JdbcUtils.getConn();
        PreparedStatement pstms = conn.prepareStatement(sql);
        System.out.println("values" + values.length);
        System.out.println(sql);
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                System.out.println("value[]=" + values[i]);
                pstms.setObject(i + 1, values[i]);
            }
        }
        result = pstms.executeUpdate();

        return result;
    }

}
