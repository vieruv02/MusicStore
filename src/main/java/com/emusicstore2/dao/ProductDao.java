package com.emusicstore2.dao;

import java.util.List;

import com.emusicstore2.model.Product;

/**
 * Created by vladvieru on 7/27/18.
 */
//This class is USED only with database
public interface ProductDao
{
    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}