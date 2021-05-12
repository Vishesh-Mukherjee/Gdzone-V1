package com.gdgu.ekart.dao;

import com.gdgu.ekart.entity.Product;
import com.gdgu.ekart.util.ToDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ProductDaoCollImplTest {

    ProductDaoCollImpl testObj;

    @BeforeEach
    public void setup() {
        testObj = new ProductDaoCollImpl();
    }

    @Test
    public void getProductListAdmineTest() {
        Assertions.assertFalse(testObj.getProductListAdmine().isEmpty());
        Assertions.assertEquals(9, testObj.getProductListAdmine().size());
    }

    @Test
    public void getProductListCustomerTest() {
        Assertions.assertFalse(testObj.getProductListCutomer().isEmpty());
        Assertions.assertEquals(4, testObj.getProductListCutomer().size());
    }

    @Test
    public void addProdouctTest() {
        Assertions.assertTrue(testObj.addProdouct(new Product(1010, "Niagara Falls", "100% Trust", "Beverages", 399, ToDate.strToDate("12-09-2050"), true, false)));
        Assertions.assertFalse(testObj.addProdouct(new Product(1005, "HP Laptop", "To make what we make. To invent, and to reinvent.", "Electronics", 55999, null, true, true)));
    }

    @ParameterizedTest
    @ValueSource(longs = {1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009})
    public void removeProductTest(long productId) {
        Assertions.assertTrue(testObj.removeProduct(productId));
        Assertions.assertFalse(testObj.removeProduct(1010));
    }

    @Test
    public void modifyProductTest() {
        Assertions.assertTrue(testObj.modifyProduct(new Product(1005, "Zara Black-Shirt", "Designed by Professionals", "Cloths", 3599, null, true, false)));
        Assertions.assertFalse(testObj.modifyProduct(new Product(1010, "Gucci Black-Shirt", "", "Quality is remembered long after price is forgotten", 8799, null, false, true)));
    }

    @ParameterizedTest
    @ValueSource(longs = {1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009})
    public void getProductNotNullTest(long productId) {
        Assertions.assertNotNull(testObj.getProduct(productId));
    }

    @ParameterizedTest
    @ValueSource(longs = {1010, 1011, 1012, 1013})
    public void getProductNullTest(long productId) {
        Assertions.assertNull(testObj.getProduct(productId));
    }
}
