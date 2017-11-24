package com.lk.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.annotation.Service;

import com.lk.helper.DatabaseHelper;
import com.lk.model.Customer;
import com.lk.util.PropsUtil;
@Service
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
        String sql = "select * from customer where id =" + id;
        return DatabaseHelper.queryEntity(Customer.class, sql);
    }
    /*
     * 创建客户
     */
    public boolean createCustomer(Map<String, Object> map) {
        return DatabaseHelper.insertEntity(Customer.class, map);
    }
    /*
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String, Object> map) {
        return DatabaseHelper.updateEntity(Customer.class, id, map);
    }
    /*
     * 删除客户
     */
    public boolean deleteCustomer(long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }

}
