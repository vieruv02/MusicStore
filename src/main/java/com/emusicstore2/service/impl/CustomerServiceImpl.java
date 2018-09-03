package com.emusicstore2.service.impl;

import com.emusicstore2.dao.CustomerDao;
import com.emusicstore2.model.Customer;
import com.emusicstore2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vladvieru on 8/25/18.
 */
@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerDao customerDao;

    @Override
    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        try {
            return customerDao.getAllCustomers();
        }catch (Exception e) {
            String ex = e.getMessage();
            return null;
        }
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerDao.getCustomerByUsername(username);
    }
}