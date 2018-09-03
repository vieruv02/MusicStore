package com.emusicstore2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vladvieru on 8/19/18.
 */

@Entity
public class Customer implements Serializable
{
    private static final long serialVersionUID = -499881931594335446L;


//We use GenerationType.IDENTITY because initially when I created the table I didn't set the id as auto_increment
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "customerId")

    @Id
    @GeneratedValue
    private int customerId;


    @NotEmpty(message = "The customer name must not be null")
    private String customerName;

    @NotEmpty(message = "The customer email must not be null")
    private String customerEmail;

    private String customerPhone;

    @NotEmpty(message = "The customer username must not be null")
    private String username;

    @NotEmpty(message = "The customer password must not be null")
    private String password;


    //Something is not filled out in the form
    private boolean enabled;


    //One customer can have one address
    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;


    //One customer can have one shipping address
    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;

    //One customer can have one cart
    @OneToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;



    //Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
