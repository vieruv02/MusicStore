package com.emusicstore2.dao;

import com.emusicstore2.model.Cart;
import com.emusicstore2.model.CartItem;

/**
 * Created by vladvieru on 8/29/18.
 */

public interface CartItemDao
{
    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);
}
