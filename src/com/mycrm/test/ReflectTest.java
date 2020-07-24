package com.mycrm.test;

import com.mycrm.pojo.Customer;
import com.mycrm.service.CustomerService;
import com.mycrm.service.impl.CustomerServiceImpl;
import com.mycrm.tools.ServiceProxyHandler;
import org.junit.Test;

import java.lang.reflect.*;

public class ReflectTest {
//    @Test
//    public void testProxy() {
//        CustomerService service = new ServiceProxyHandler<CustomerService>().createProxyService(new CustomerServiceImpl());
//        System.out.println( service.getCustByid(1));
//    }
//
//    @Test
//    public void testMethod() {
//        String className = "com.mycrm.pojo.Customer";
//        String fieldName = "custname";
//        String fieldValue = "zhansan";
//        String methodName = "setTel";
//        String argsTypes = "java.lang.String";
//        String argsValues = "13833546346";
//        try {
//            Class cls = Class.forName(className);
//            //    Object obj = cls.newInstance();
//            Constructor declaredConstructor = cls.getDeclaredConstructor();
//            Object obj = declaredConstructor.newInstance();
//
//            //
//            Field field = cls.getDeclaredField(fieldName);
//            field.setAccessible(true);
//            field.set(obj, fieldValue);
//            Class argsTypeClass = Class.forName(argsTypes);
//            Method declaredMethod = null;
//            declaredMethod = cls.getDeclaredMethod(methodName, argsTypeClass);
//            declaredMethod.invoke(obj, argsValues);
//
//            System.out.println(obj);
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    @Test
//    public void testReflect() {
//        String className = "com.mycrm.pojo.Customer";
//        try {
//            Class cls = Class.forName(className);
//            String modify = Modifier.toString(cls.getModifiers());
//            String name = cls.getName();
//            System.out.println(modify + " class " + name + "{");
//            Field[] declaredFields = cls.getDeclaredFields();
//            for (Field field : declaredFields) {
//                modify = Modifier.toString(field.getModifiers());
//                name = field.getName();
//                String type = field.getType().getName();
//                System.out.println(modify + " " + type + " " + name);
//
//            }
//            Constructor[] declaredConstructors = cls.getDeclaredConstructors();
//            for (Constructor constructor : declaredConstructors) {
//                modify = Modifier.toString(constructor.getModifiers());
//                name = constructor.getName();
//                Class[] parameterTypes = constructor.getParameterTypes();
//                System.out.println(modify + " " + name + "(");
//                for (Class parameterType : parameterTypes) {
//                    System.out.println(parameterType.getName() + ",");
//                }
//                System.out.println("){}");
//
//            }
//            Method[] declaredMethods = cls.getDeclaredMethods();
//            for (Method method : declaredMethods) {
//                modify = Modifier.toString(method.getModifiers());
//                String type = method.getReturnType().getName();
//                name = method.getName();
//                Class[] parameterTypes = method.getParameterTypes();
//                System.out.println(modify + " " + type + " " + name + "(");
//                for (Class parameterType : parameterTypes) {
//                    System.out.println(parameterType.getName() + ",");
//                }
//                System.out.println("){}");
//            }
//            System.out.println("}");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }


}

