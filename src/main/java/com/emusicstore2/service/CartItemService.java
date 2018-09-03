package com.emusicstore2.service;

import com.emusicstore2.model.Cart;
import com.emusicstore2.model.CartItem;
import org.springframework.stereotype.Service;

/**
 * Created by vladvieru on 8/29/18.
 */

public interface CartItemService
{
    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);
}
