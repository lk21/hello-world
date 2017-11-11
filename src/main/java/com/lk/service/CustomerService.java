package com.lk.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lk.helper.DatabaseHelper;
import com.lk.model.Customer;
import com.lk.util.PropsUtil;

public class CustomerService {
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    
    
    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList() {
        //
        String sql = "select * from customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }
    
    public Customer getCustomer(long id) {
        //
        return null;
    }
    
    public boolean createCustomer(Map<String, Object> map) {
        return false;
    }
    
    public boolean updateCustomer(long id, Map<String, Object> map) {
        return false;
    }
    
    public boolean deleteCustomer(long id) {
        return false;
    }

}
