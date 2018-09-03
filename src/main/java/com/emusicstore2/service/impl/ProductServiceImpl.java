package com.emusicstore2.service.impl;

import com.emusicstore2.dao.ProductDao;
import com.emusicstore2.model.Product;
import com.emusicstore2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vladvieru on 8/21/18.
 */

@Service
public class ProductServiceImpl implements ProductService
{

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(int productId){
        return productDao.getProductById(productId);
    }

    @Override
    public List<Product> getProductList(){
        return productDao.getProductList();
    }

    @Override
    public void addProduct(Product product){
        productDao.addProduct(product);
    }

    @Override
    public void editProduct(Product product){
        productDao.editProduct(product);
    }

    @Override
    public void deleteProduct(Product product){
        productDao.deleteProduct(product);
    }
}
