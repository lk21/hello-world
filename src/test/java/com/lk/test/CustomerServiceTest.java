package com.lk.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.lk.helper.DatabaseHelper;
import com.lk.model.Customer;
import com.lk.service.CustomerService;

import junit.framework.Assert;


public class CustomerServiceTest {
    
    private final CustomerService customerService;
    
    public CustomerServiceTest() {
        customerService = new CustomerService();
    }
    
    
    @Before
    public void init() throws Exception {
        DatabaseHelper.executeSqlFile("sql/customer_init.sql");
    }
    
    @Test
    public void getCustomerListTest() throws Exception {
        List<Customer> customers = customerService.getCustomerList();
        Assert.assertEquals(2, customers.size());
    }
    
    @Test
    public void getCustomerTest() throws Exception {
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }
    
    @Test
    public void createCustomerTest() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "c3");
        map.put("contact", "3");
        map.put("telephone", "3");
        boolean result = customerService.createCustomer(map);
        Assert.assertTrue(result);
    }
    
    @Test
    public void updateCustomerTest() throws Exception {
        long id = 2;
        Map<String, Object> map = new HashMap<>();
        map.put("contact", "林凯");
        boolean result = customerService.updateCustomer(id, map);
        Assert.assertTrue(result);
    }
    
    @Test
    public void deleteCustomerTest() throws Exception {
        long id = 1;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }

}
