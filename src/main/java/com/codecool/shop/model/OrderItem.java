package com.codecool.shop.model;

import java.util.Map;

public class OrderItem {
    private int productID, quantity;

    public OrderItem(Map.Entry<ProductCategory, Integer> item) {
        productID = item.getKey().getId();
        quantity = item.getValue();
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }
}
