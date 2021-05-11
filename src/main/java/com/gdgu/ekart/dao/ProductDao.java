package com.gdgu.ekart.dao;

import java.util.List;

import com.gdgu.ekart.entity.Product;

public interface ProductDao {

    List<Product> getProductListAdmine();
    List<Product> getProductListCutomer();
    boolean addProdouct(Product product);
    boolean removeProduct(long productId);
    boolean modifyProduct(Product product);
    Product getProduct(long productId);
    
}
