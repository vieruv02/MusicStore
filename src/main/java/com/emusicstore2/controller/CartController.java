package com.emusicstore2.controller;

import com.emusicstore2.model.Customer;
import com.emusicstore2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vladvieru on 8/29/18.
 */

//Shopping cart

@Controller
@RequestMapping("/customer/cart")
public class CartController
{
    @Autowired
    private CustomerService customerService;

    //@AuthenticationPrincipal is the person that has logged in the system
    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser){
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());

        //retrieve the cart and cartId when we register the customer
        int cartId=customer.getCart().getCartId();

        return "redirect:/customer/cart/" + cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable (value = "cartId") int cartId, Model model){
        model.addAttribute("cartId", cartId);

        return "cart";
    }
}

