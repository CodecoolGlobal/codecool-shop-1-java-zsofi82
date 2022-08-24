package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.SuperHeroDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.SuperHero;
import com.codecool.shop.model.SuperPower;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SuperHeroDaoMem implements SuperHeroDao {

    private List<SuperHero> data = new ArrayList<>();
    private static SuperHeroDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private SuperHeroDaoMem() {
    }

    public static SuperHeroDao getInstance() {
        if (instance == null) {
            instance = new SuperHeroDaoMem();
        }
        return instance;
    }

    @Override
    public void add(SuperHero superHero) {
        superHero.setId(data.size() + 1);
        data.add(superHero);
    }

    @Override
    public SuperHero find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<SuperHero> getAll() {
        return data;
    }

    @Override
    public List<SuperHero> getBySuperPower(SuperPower superPower) {
        return data.stream().filter(t -> t.getSuperPowers().contains(superPower)).collect(Collectors.toList());
    }
}
