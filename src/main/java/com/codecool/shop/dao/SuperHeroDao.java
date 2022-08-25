package com.codecool.shop.dao;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.SuperHero;
import com.codecool.shop.model.SuperPower;

import java.util.List;

public interface SuperHeroDao {

    void add(SuperHero superHero);
    SuperHero find(int id);
    void remove(int id);

    List<SuperHero> getAll();
    List<SuperHero> getBySuperPower(SuperPower superPower);
    List<SuperHero> getByCategory(ProductCategory category);
}
