package com.emusicstore2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.List;

/**
 * Created by vladvieru on 7/27/18.
 */
@Entity
public class Product implements Serializable
{
    //It is a plugin - to develop our check out process
    private static final long serialVersionUID = -4276923448724906332L;


    //@Id /*@Id for database*/
    //@GeneratedValue(strategy= GenerationType.AUTO) /*when creates a new instance the product id will be generated automatically (for Database)*/



    //We use GenerationType.IDENTITY because initially when I created the table I didn't set the id as auto_increment
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "productId")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;


    @NotEmpty (message = "The product name must not be null") /*means that when adding a new product this field must not be empty*/
    private String productName;

    private String productCategory;
    private String productDescription;

    @Min(value = 0, message = "The product must not be less than 0")
    private double productPrice;

    private String productCondition;
    private String productStatus;

    @Min(value = 0, message = "The product unit must not be less than 0")
    private int unitInStock;

    private String productManufacturer;

    @Transient
    private MultipartFile productImage;


    //One product can be in multiple cart items or one cart item can be only in one product
    //product is the father
    //JsonIgnore - when you try to convert the class to JSON this method will be omitted - we do that because
    @OneToMany(mappedBy = "product", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;



    //Getters and Setters

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    //Getters and Setters (cmnd+N)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}