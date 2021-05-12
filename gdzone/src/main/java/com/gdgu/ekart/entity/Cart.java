package com.gdgu.ekart.entity;

import java.util.List;
import java.util.Objects;

public class Cart {
    private List<Product> productList;
    private double total;
    
    public Cart() {
    }

    public Cart(List<Product> productList, double total) {
        this.productList = productList;
        this.total = total;
    }

    public List<Product> getProductList() {
        return this.productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cart)) {
            return false;
        }
        Cart cart = (Cart) o;
        return Objects.equals(productList, cart.productList) && total == cart.total;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productList, total);
    }

}
