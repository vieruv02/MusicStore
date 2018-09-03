package com.emusicstore2.controller;

import com.emusicstore2.model.Product;
import com.emusicstore2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * Created by vladvieru on 8/21/18.
 */

//ProductController can be accessed by both the customer and administrator

@Controller
@RequestMapping("/product")
public class ProductController
{
    //Autowire ProductService bean
    @Autowired
    private ProductService productService;

    @RequestMapping("/productList")
    public String getProducts(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productList";
    }


    //viewProduct STUFF BEGINS - we write it here because it can be accessed by both the customer and administrator
    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable("productId") int productId, Model model) throws IOException{
        Product product=productService.getProductById(productId);
        model.addAttribute("product", product);

        return "viewProduct";
    }

    //viewProduct STUFF ENDS
}