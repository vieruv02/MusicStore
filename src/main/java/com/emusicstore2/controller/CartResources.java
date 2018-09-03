package com.emusicstore2.controller;

import com.emusicstore2.model.Cart;
import com.emusicstore2.model.CartItem;
import com.emusicstore2.model.Customer;
import com.emusicstore2.model.Product;
import com.emusicstore2.service.CartItemService;
import com.emusicstore2.service.CartService;
import com.emusicstore2.service.CustomerService;
import com.emusicstore2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vladvieru on 8/29/18.
 */
//Rest Service controller - use it as resources used to provide with cart view page with resources

@Controller
@RequestMapping("/rest/cart")
public class CartResources
{
    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemService cartItemService;

    //Map the cartId path and responding to return a Cart object and turn it into JSON format (@ResponseBody)
    @RequestMapping("/{cartId}")
    public @ResponseBody Cart getCartById(@PathVariable(value = "cartId") int cartId){
        return cartService.getCartById(cartId);
    }

    //this method will be used as addItem and map it with http request method of PUT
    //GET is used to retrieve info
    //POST is used to submit a form
    //PUT is used to update some info
    //DELETE is used to delete some info
    /*When you add an item to your cart you want to first see if this product already exists in the cart. If it already exists we just increase the
    quantity by one, if not then just add a new item and set the quantity = 1*/

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") int productId, @AuthenticationPrincipal User activeUser){

        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        Cart cart = customer.getCart();
        Product product = productService.getProductById(productId);
        List<CartItem> cartItems = cart.getCartItems();

        //loop through the items in the cart
        for(int i=0; i<cartItems.size(); i++){
            //if this product is a product that already exists in the cart then we increase the quantity by 1
            if(product.getProductId() == cartItems.get(i).getProduct().getProductId()){
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return; //we add an empty return to finish the execution of the loop
            }
        }

        //If we haven't found any item in the cart then we add a new product to the cartItem and save it in database
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable(value = "productId") int productId){
        CartItem cartItem = cartItemService.getCartItemByProductId(productId);
        cartItemService.removeCartItem(cartItem);
    }


    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable(value = "cartId") int cartId){
        Cart cart = cartService.getCartById(cartId);
        cartItemService.removeAllCartItems(cart);
    }



    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientErrors(Exception e){}


    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error")
    public void handleServerErrors(Exception e){}
}
