package com.lk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lk.model.Customer;
import com.lk.service.CustomerService;
/*
 * 进入客户列表界面
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet{
    
    private CustomerService customerService;
    
    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List<Customer> customerList = customerService.getCustomerList();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/WEB-INF/jsp/customer.jsp").forward(request, response);
    }

}
