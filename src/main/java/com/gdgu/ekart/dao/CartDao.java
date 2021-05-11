package com.gdgu.ekart.dao;

import java.util.List;

import com.gdgu.ekart.entity.Product;

public interface CartDao {
    List<Product> getAllCartItems(long userId);
    double getCartTotal(long userId);
    boolean addCartItem(long userId, long productId);
    boolean removeCartItem(long userId, long productId);
}
