package com.codecool.shop.model;

import java.util.List;

public class OrderResponse {
    List<SuperHero> heroes;
    List<ProductCategory> productcategories;
    List<OrderItem> orderitems;

    public OrderResponse(List<SuperHero> heroes, List<ProductCategory> products, List<OrderItem> orderitems) {
        this.heroes = heroes;
        this.productcategories = products;
        this.orderitems = orderitems;
    }

    public OrderResponse() {
    }
}
