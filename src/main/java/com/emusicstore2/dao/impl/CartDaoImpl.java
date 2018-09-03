package com.emusicstore2.dao.impl;

import com.emusicstore2.dao.CartDao;
import com.emusicstore2.model.Cart;
import com.emusicstore2.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vladvieru on 8/29/18.
 */

@Repository
@Transactional
public class CartDaoImpl implements CartDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Cart getCartById(int cartId) {
//        Session session = sessionFactory.getCurrentSession();
//        Cart cart = (Cart)session.get(Cart.class, cartId);
//        session.flush();
//
//        return cart;

        Session session = sessionFactory.getCurrentSession();
        return (Cart)session.get(Cart.class, cartId);
    }

    @Override
    public void update(Cart cart) {
        int cartId = cart.getCartId();
    }
}
