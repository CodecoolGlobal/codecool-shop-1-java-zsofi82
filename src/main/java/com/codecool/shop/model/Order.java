package com.codecool.shop.model;

import java.util.HashMap;
import java.util.Map;

public class Order extends BaseModel{
    private final Map<Product, Integer> products;

    public Order() {
        super("");
        products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException(String.format("Cant add zero or negative products: %d", quantity));
        }
        products.put(
            product,
            quantity + products.getOrDefault(product, 0)
        );
    }

    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public Map<Product, Integer> getProducts() {
        return Map.copyOf(products);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void decreaseProduct(Product product, int quantity) {
        if (products.containsKey(product)) {
            if (products.get(product) <= quantity) {
                removeProduct(product);
            } else {
                products.put(product, products.get(product) - quantity);
            }
        }
    }
}
