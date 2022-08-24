package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class SuperHero extends BaseModel {
    private List<Product> products;

    private List<SuperPower> superPowers;


    public SuperHero(String name, String description) {
        super(name);
        this.products = new ArrayList<>();
        this.superPowers = new ArrayList<>();
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addSuperPower(SuperPower superPower) {
        superPowers.add(superPower);
    }
    @Override
    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "description: %3$s",
                this.id,
                this.name,
                this.description
        );
    }

    public List<SuperPower> getSuperPowers() {
        return superPowers;
    }
}