package com.gdgu.ekart.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.gdgu.ekart.entity.Cart;
import com.gdgu.ekart.entity.Product;

public class CartDaoCollImpl implements CartDao {

    private HashMap<Long, Cart> userCart;

    public CartDaoCollImpl() {
        if (userCart == null) {
            userCart = new HashMap<Long, Cart>();
        }
    }

    @Override
    public List<Product> getAllCartItems(long userId) {
        return userCart.get(userId) == null? null: userCart.get(userId).getProductList();
    }

    @Override
    public double getCartTotal(long userId) {
        return userCart.get(userId).getTotal();
    }

    @Override
    public boolean addCartItem(long userId, long productId) {
        ProductDaoCollImpl prod = new ProductDaoCollImpl();
        if (!userCart.containsKey(userId)) {
            userCart.put(userId, new Cart(new ArrayList<Product>(), 0));
        }

        if (prod.getProductListCutomer().stream().anyMatch(x -> x.getId() == productId)) {
            userCart.get(userId).getProductList().add(prod.getProduct(productId));
            userCart.get(userId).setTotal(
                                            userCart.get(userId)
                                            .getProductList().stream()
                                            .mapToDouble(Product::getPrice)
                                            .sum()
                                        );
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeCartItem(long userId, long productId) {
        if (userCart.containsKey(userId)) {
            if (userCart.get(userId).getProductList().stream().anyMatch(x -> x.getId() == productId)) {
                userCart.get(userId).setProductList(
                                                    userCart.get(userId)
                                                    .getProductList().stream()
                                                    .filter(x -> x.getId() != productId)
                                                    .collect(Collectors.toList())
                                                    );
                userCart.get(userId).setTotal(
                                            userCart.get(userId)
                                            .getProductList().stream()
                                            .mapToDouble(Product::getPrice)
                                            .sum()
                                        );
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
}
