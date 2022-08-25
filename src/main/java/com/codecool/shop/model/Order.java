package com.codecool.shop.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Order extends BaseModel{
    private final Map<ProductCategory, Integer> products;

    public Order() {
        super("");
        products = new HashMap<>();
    }

    public void setProductQuantity(ProductCategory product, int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException(String.format("Cant add zero or negative products: %d", quantity));
        }
        products.put(product, quantity);
    }

    public List<OrderItem> getProducts() {
        return products.entrySet().stream()
            .map(OrderItem::new)
            .collect(Collectors.toList());
    }

    public void removeProduct(ProductCategory product) {
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
