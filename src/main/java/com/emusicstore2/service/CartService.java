package com.emusicstore2.service;

import com.emusicstore2.model.Cart;

/**
 * Created by vladvieru on 8/29/18.
 */

public interface CartService
{
    Cart getCartById(int cartId);

    void update(Cart cart);
}

