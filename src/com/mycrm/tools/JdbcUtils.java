package com.mycrm.tools;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DruidDataSource dataSource;

    static {
        InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataSource = new DruidDataSource();
        dataSource.setDriverClassName(properties.getProperty("jdbc.driver"));
        dataSource.setUrl(properties.getProperty("jdbc.url"));
        dataSource.setUsername(properties.getProperty("jdbc.username"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(15);
        dataSource.setMinIdle(5);
        dataSource.setMaxWait(10000);
        dataSource.setMinEvictableIdleTimeMillis(10000);
    }

    //private static Connection conn = null;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    public static Connection getConn() {
        if (threadLocal.get() == null) {
            threadLocal.set(createConn());
            System.out.println("threadLocal.set(createConn());\n");
        }
        return threadLocal.get();
    }

    //创建链接
    private static Connection createConn() {
        //        Connection conn = null;
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void closeALL(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                threadLocal.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
