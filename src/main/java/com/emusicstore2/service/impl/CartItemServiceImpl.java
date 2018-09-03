package com.emusicstore2.service.impl;

import com.emusicstore2.dao.CartItemDao;
import com.emusicstore2.model.Cart;
import com.emusicstore2.model.CartItem;
import com.emusicstore2.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vladvieru on 8/29/18.
 */

@Service
public class CartItemServiceImpl implements CartItemService
{
    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    @Override
    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    @Override
    public void removeAllCartItems(Cart cart) {
        cartItemDao.removeAllCartItems(cart);
    }

    @Override
    public CartItem getCartItemByProductId(int productId){
        return cartItemDao.getCartItemByProductId(productId);
    }
}
