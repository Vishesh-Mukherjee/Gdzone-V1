package com.gdgu.ekart.entity;

import java.util.Date;
import java.util.Objects;

public class Product {

    private long id;
    private String titile;
    private String description;
    private String category;
    private double price;
    private Date dateOfExpriy;
    private boolean inStock;
    private boolean freeDelivery;

    public Product(long id, String titile, String description, String category, double price, Date dateOfExpriy, boolean inStock, boolean freeDelivery) {
        this.id = id;
        this.titile = titile;
        this.description = description;
        this.category = category;
        this.price = price;
        this.dateOfExpriy = dateOfExpriy;
        this.inStock = inStock;
        this.freeDelivery = freeDelivery;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitile() {
        return this.titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateOfExpriy() {
        return this.dateOfExpriy;
    }

    public void setDateOfExpriy(Date dateOfExpriy) {
        this.dateOfExpriy = dateOfExpriy;
    }

    public boolean isInStock() {
        return this.inStock;
    }

    public boolean getInStock() {
        return this.inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public boolean isFreeDelivery() {
        return this.freeDelivery;
    }

    public boolean getFreeDelivery() {
        return this.freeDelivery;
    }

    public void setFreeDelivery(boolean freeDelivery) {
        this.freeDelivery = freeDelivery;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", titile='" + getTitile() + "'" +
            ", description='" + getDescription() + "'" +
            ", category='" + getCategory() + "'" +
            ", price='" + getPrice() + "'" +
            ", dateOfExpriy='" + getDateOfExpriy() + "'" +
            ", inStock='" + isInStock() + "'" +
            ", freeDelivery='" + isFreeDelivery() + "'" +
            "}";
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return id == product.id && Objects.equals(titile, product.titile) && Objects.equals(description, product.description) && Objects.equals(category, product.category) && price == product.price && Objects.equals(dateOfExpriy, product.dateOfExpriy) && inStock == product.inStock && freeDelivery == product.freeDelivery;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titile, description, category, price, dateOfExpriy, inStock, freeDelivery);
    }
    
}
