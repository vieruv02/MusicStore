package com.emusicstore2.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vladvieru on 8/20/18.
 */

@Entity
public class CustomerOrder implements Serializable
{
    private static final long serialVersionUID = 2056220708294487395L;


    //We use GenerationType.IDENTITY because initially when I created the table I didn't set the id as auto_increment
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "customerOrderId")

    @Id
    @GeneratedValue
    private int customerOrderId;


    //One order will be binded to one cart
    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;


    //One customer is binded to one order
    @OneToOne
    @JoinColumn(name = "customerId")
    private Customer customer;


    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;


    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;



    //Getters and Setters
    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}