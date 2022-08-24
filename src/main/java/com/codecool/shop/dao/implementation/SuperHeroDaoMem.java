package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.SuperHeroDao;
import com.codecool.shop.model.SuperHero;

import java.util.ArrayList;
import java.util.List;

public class SuperHeroDaoMem implements SuperHeroDao {

    private List<SuperHero> data = new ArrayList<>();
    private static SuperHeroDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private SuperHeroDaoMem() {
    }

    public static SuperHeroDaoMem getInstance() {
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
}
