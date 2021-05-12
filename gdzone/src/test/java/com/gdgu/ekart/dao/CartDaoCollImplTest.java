package com.gdgu.ekart.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CartDaoCollImplTest {
    CartDaoCollImpl testObj;

    @BeforeEach
    public void setup() {
        testObj = new CartDaoCollImpl();
    }

    @ParameterizedTest
    @ValueSource(longs = {1001, 1003, 1005, 1008})
    public void addCartItemTrueTest(long productId) {
        Assertions.assertTrue(testObj.addCartItem(11, productId));
    }

    @ParameterizedTest
    @ValueSource(longs = {1002, 1004, 1006, 1007, 1009}) 
    public void addCartItemFalseTest(long productId) {
        Assertions.assertFalse(testObj.addCartItem(11, productId));
    }

    @Test
    public void removeCartItemTest() {
        Assertions.assertFalse(testObj.removeCartItem(11, 1001));

        testObj.addCartItem(22, 1005);
        Assertions.assertTrue(testObj.removeCartItem(22, 1005));

        Assertions.assertFalse(testObj.removeCartItem(22, 1004));
    }

    @Test
    public void getAllCartItemsTest() {
        testObj.addCartItem(11, 1001);
        testObj.addCartItem(11, 1003);
        testObj.addCartItem(11, 1005);
        Assertions.assertEquals(3, testObj.getAllCartItems(11).size());

        Assertions.assertNull(testObj.getAllCartItems(22));
    }

    @Test
    public void getCartTotal() {
        testObj.addCartItem(11, 1001);
        Assertions.assertEquals(24999, testObj.getCartTotal(11));
        testObj.addCartItem(11, 1003);
        Assertions.assertEquals(74998, testObj.getCartTotal(11));
        testObj.addCartItem(11, 1005);
        Assertions.assertEquals(78597, testObj.getCartTotal(11));

        testObj.removeCartItem(11, 1005);
        Assertions.assertEquals(74998, testObj.getCartTotal(11));
        testObj.removeCartItem(11, 1003);
        Assertions.assertEquals(24999, testObj.getCartTotal(11));
        testObj.removeCartItem(11, 1001);
        Assertions.assertEquals(0, testObj.getCartTotal(11));
    }
}
