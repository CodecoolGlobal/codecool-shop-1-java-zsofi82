package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Order extends BaseModel{
    private final List<OrderItem> products;

    public Order() {
        super("");
        products = new ArrayList<>();
    }

    public void setProductQuantity(ProductCategory product, SuperHero hero, int quantity) {
        /*if (quantity < 1) {
            throw new IllegalArgumentException(String.format("Cant add zero or negative products: %d", quantity));
        }*/
        int orderItemIndex = products.indexOf(new OrderItem(product.getId(), hero.getId()));
        if (orderItemIndex == -1) {
            products.add(new OrderItem(product.getId(), hero.getId(), quantity));
        } else {
            products.get(orderItemIndex).setQuantity(quantity);
        }
    }

    public List<OrderItem> getProducts() {
        return List.copyOf(products);
    }

    public void removeProduct(ProductCategory product, SuperHero hero) {
        products.remove(new OrderItem(product.getId(), hero.getId()));
    }
}
