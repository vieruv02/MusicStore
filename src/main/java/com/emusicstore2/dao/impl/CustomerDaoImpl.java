package com.emusicstore2.dao.impl;

import com.emusicstore2.dao.CustomerDao;
import com.emusicstore2.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vladvieru on 8/25/18.
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomer(Customer customer){
        Session session = sessionFactory.getCurrentSession();

        //having billing and shipping address pointing to the current customer
        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        //Saving data of new customer to generate an automatic customerId
        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        //We add new users (customers) through hibernate - we add to the USERS table
        Users newUser = new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(true);
        newUser.setCustomerId(customer.getCustomerId());


        //We add new users (customers) through hibernate - we add to the AUTHORITIES table
        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(customer.getUsername());
        newAuthority.setAuthority("ROLE_USER");

        //Saving our new customer as a user and authority
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        //Generate a Cart to bind it to the customer
        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);

        //We save customer here as well as the top because we have modified the customer field by adding a new cart to it
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    @Override
    public Customer getCustomerById(int customerId){
        Session session = sessionFactory.getCurrentSession();
        return (Customer)session.get(Customer.class, customerId);
    }

    @Override
    public List<Customer> getAllCustomers(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();

        return customerList;
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        //username=? means username = dynamic value

        Query query = session.createQuery("from Customer where username=?");

        //0 means the first place
        query.setString(0, username);

        return (Customer)query.uniqueResult();
    }
}
