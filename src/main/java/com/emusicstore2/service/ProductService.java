package com.emusicstore2.service;

import com.emusicstore2.model.Product;

import java.util.List;

/**
 * Created by vladvieru on 8/21/18.
 */

public interface ProductService
{
    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
