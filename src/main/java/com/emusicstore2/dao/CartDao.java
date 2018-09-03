package com.emusicstore2.dao;

import com.emusicstore2.model.Cart;

/**
 * Created by vladvieru on 8/7/18.
 */
public interface CartDao
{
    Cart getCartById(int cartId);

    void update(Cart cart);
}
