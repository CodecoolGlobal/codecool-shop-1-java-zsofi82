package com.codecool.shop.model;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;


public class SuperHero extends BaseModel {
    private List<ProductCategory> productCategories;

    @Expose
    private List<SuperPower> superPowers;


    public SuperHero(String name, String description) {
        super(name);
        this.productCategories = new ArrayList<>();
        this.superPowers = new ArrayList<>();
    }

    public void addCategory(ProductCategory category) {
        productCategories.add(category);
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

    public List<ProductCategory> getProductCategories() {
        return productCategories;
    }

    public List<SuperPower> getSuperPowers() {
        return superPowers;
    }
}