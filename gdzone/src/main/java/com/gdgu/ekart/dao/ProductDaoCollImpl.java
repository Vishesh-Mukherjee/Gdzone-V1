package com.gdgu.ekart.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.gdgu.ekart.entity.Product;
import com.gdgu.ekart.util.ToDate;

public class ProductDaoCollImpl implements ProductDao{

    private List<Product> productList;

    public ProductDaoCollImpl() {
        if (productList == null) {
            productList = new ArrayList<Product>();
            productList.add(new Product(1001, "I Phone 8", "Designed by Apple in California. Assembled in China", "Electronics", 24999, null, true, false));
            productList.add(new Product(1002, "I Phone 9", "Designed by Apple in California. Assembled in China", "Electronics", 38999, null, false, false));
            productList.add(new Product(1003, "I Phone 10", "Designed by Apple in California. Assembled in China", "Electronics", 49999, null, true, true));
            productList.add(new Product(1004, "I Phone 11", "Designed by Apple in California. Assembled in China", "Electronics", 89999, null, false, true));
            productList.add(new Product(1005, "Zara Black-Shirt", "Designed by Professionals", "Cloths", 3599, null, true, false));
            productList.add(new Product(1006, "Gucci Black-Shirt", "", "Quality is remembered long after price is forgotten", 8799, null, false, true));
            productList.add(new Product(1007, "Sweden Dry Fruits", "Harvested in Sweden", "Food", 1299, ToDate.strToDate("08-04-2020"), true, true));
            productList.add(new Product(1008, "Japaness Dry Fruits", "Harvested in Japan", "Food", 2359, ToDate.strToDate("28-05-2032"), true, true));
            productList.add(new Product(1009, "Himalayan Water", "Himalayan Mountain", "Beverages", 1299, ToDate.strToDate("23-08-2054"), false, true));
        }
    }

    @Override
    public List<Product> getProductListAdmine() {
        return productList;
    }

    @Override
    public List<Product> getProductListCutomer() {
        Date currentDate = new Date();
        return productList.stream()
                            .filter(x -> (x.getDateOfExpriy() == null? true: x.getDateOfExpriy().after(currentDate)) && x.getInStock())
                            .collect(Collectors.toList());
    }

    @Override
    public boolean addProdouct(Product product) {
        if (productList.stream().anyMatch(x -> x.getId() == product.getId())) {
            return false;
        } else {
            productList.add(product);
            return true;
        }
    }

    @Override
    public boolean removeProduct(long productId) {
        if (productList.stream().noneMatch(x -> x.getId() == productId)) {
            return false;
        } else {
            productList = productList.stream()
                                        .filter(x -> x.getId() != productId)
                                        .collect(Collectors.toList());
            return true;
        }
    }

    @Override
    public boolean modifyProduct(Product product) {
        if (productList.stream().noneMatch(x -> x.getId() == product.getId())) {
            return false;
        } else {
            productList = productList.stream()
                                        .map(x -> x.getId() == product.getId()? product: x)
                                        .collect(Collectors.toList());
            return true;
        }
    }

    @Override
    public Product getProduct(long productId) {
        return productList.stream().filter(x -> x.getId() == productId).findAny().orElse(null);
    }

}
