package com.mycrm.tools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class ServiceProxyHandler<T> implements InvocationHandler {
    //被代理对象
    private T proxyObj;

    public T createProxyService(T proxyObj) {
        this.proxyObj = proxyObj;
        T proxyAfter = (T) Proxy.newProxyInstance(proxyObj.getClass().getClassLoader(), proxyObj.getClass().getInterfaces(), this);
        return proxyAfter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Connection conn = JdbcUtils.getConn();
        System.out.println(conn.isClosed());
        try {
            conn.setAutoCommit(false);
            method.setAccessible(true);
            Object result = method.invoke(proxyObj, args);
            conn.commit();
            System.out.println("记录事务结束");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            System.out.println("JdbcUtils.closeALL(conn);");
            System.out.println(conn.getClass());
            if (conn!=null){
                JdbcUtils.closeALL(conn);
            }
        }
        return null;
    }
}
