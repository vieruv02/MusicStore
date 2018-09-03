package com.emusicstore2.service.impl;

import com.emusicstore2.dao.CartDao;
import com.emusicstore2.model.Cart;
import com.emusicstore2.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vladvieru on 8/29/18.
 */

@Service
public class CartServiceImpl implements CartService
{
    @Autowired
    private CartDao cartDao;

    @Override
    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    @Override
    public void update(Cart cart) {
        cartDao.update(cart);
    }
}
