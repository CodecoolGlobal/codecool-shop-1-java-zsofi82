package com.codecool.shop.dao;

import com.codecool.shop.model.SuperHero;

import java.util.List;

public interface SuperHeroDao {

    void add(SuperHero superHero);
    SuperHero find(int id);
    void remove(int id);

    List<SuperHero> getAll();
}
