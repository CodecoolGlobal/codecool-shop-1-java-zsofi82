package com.codecool.shop.service;

import com.codecool.shop.dao.SuperHeroDao;
import com.codecool.shop.dao.SuperPowerDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.SuperHero;
import com.codecool.shop.model.SuperPower;

import java.util.List;

public class SuperHeroService {
    private SuperPowerDao superPowerDao;
    private SuperHeroDao superHeroDao;

    public SuperHeroService(SuperPowerDao superPowerDao, SuperHeroDao superHeroDao) {
        this.superPowerDao = superPowerDao;
        this.superHeroDao = superHeroDao;
    }

    public List<SuperHero> getSuperHeroesForSuperPower(int superPowerId) {
        var superPower = superPowerDao.find(superPowerId);
        return superHeroDao.getBySuperPower(superPower);
    }
    public SuperPower getSuperPower(int superPowerId) {
        return superPowerDao.find(superPowerId);
    }
    public List<SuperPower> getAllSuperPower(){return superPowerDao.getAll();}
}
