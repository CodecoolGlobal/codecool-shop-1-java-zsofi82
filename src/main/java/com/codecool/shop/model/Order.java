package com.codecool.shop.model;

import java.util.HashMap;
import java.util.Map;

public class Order extends BaseModel{
    private final Map<Product, Integer> products;

    public Order() {
        super("");
        products = new HashMap<>();
    }

    public void setProductQuantity(Product product, int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException(String.format("Cant add zero or negative products: %d", quantity));
        }
        products.put(product, quantity);
    }

    public Map<Product, Integer> getProducts() {
        return Map.copyOf(products);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public int getFullPrice() {
        return products.entrySet().stream()
            .mapToInt(product ->
                Integer.parseInt(product.getKey().getPrice()) * product.getValue()
            )
            .sum();
    }
}
