package com.mycrm.tools;

import com.mycrm.service.CustomerService;
import com.mycrm.service.EmployeeService;
import com.mycrm.service.impl.CustomerServiceImpl;
import com.mycrm.service.impl.EmployeeServiceImpl;

public class ServiceFactory {
    public static CustomerService createCustomerService() {
        return new ServiceProxyHandler<CustomerService>().createProxyService(new CustomerServiceImpl());
    }

    public static EmployeeService createEmployeeService() {
        return new ServiceProxyHandler<EmployeeService>().createProxyService(new EmployeeServiceImpl());
    }

}
