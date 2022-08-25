package com.codecool.shop.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class OrderResponse {
    @Expose
    List<SuperHero> heroes;
    @Expose
    List<ProductCategory> productcategories;
    @Expose
    List<OrderItem> orderitems;

    public OrderResponse(List<SuperHero> heroes, List<ProductCategory> products, List<OrderItem> orderitems) {
        this.heroes = heroes;
        this.productcategories = products;
        this.orderitems = orderitems;
    }

    public OrderResponse() {
    }
}
