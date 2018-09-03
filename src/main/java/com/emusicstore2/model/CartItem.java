package com.emusicstore2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vladvieru on 8/7/18.
 */

//CartItem class contains the details about the item

@Entity
public class CartItem implements Serializable
{
    private static final long serialVersionUID = 4520289746073988888L;



    //We use GenerationType.IDENTITY because initially when I created the table I didn't set the id as auto_increment
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cartItemId")

    @Id
    @GeneratedValue
    private int cartItemId;


    //ManyToOne - means that many cartItems can be present in one Cart
    @ManyToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;


    //ManyToOne - means that one product can belong to many CartItems
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    //number of products added to the cart
    private int quantity;
    private double totalPrice;


    //Getters and Setters

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}