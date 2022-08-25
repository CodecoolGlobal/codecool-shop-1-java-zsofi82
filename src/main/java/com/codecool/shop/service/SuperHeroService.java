package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.SuperHeroDao;
import com.codecool.shop.dao.SuperPowerDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.SuperHero;
import com.codecool.shop.model.SuperPower;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

public class SuperHeroService {
    private SuperPowerDao superPowerDao;
    private SuperHeroDao superHeroDao;
    private ProductCategoryDao productCategoryDao;

    public SuperHeroService(SuperPowerDao superPowerDao, SuperHeroDao superHeroDao, ProductCategoryDao productCategoryDao) {
        this.superPowerDao = superPowerDao;
        this.superHeroDao = superHeroDao;
        this.productCategoryDao = productCategoryDao;
    }

    public List<SuperHero> getHeroesForCategory(int categoryId){
        var category = productCategoryDao.find(categoryId);
        return superHeroDao.getByCategory(category);
    }

    public ProductCategory getProductCategory(int categoryId){
        return productCategoryDao.find(categoryId);
    }

    public List<SuperHero> getSuperHeroesForSuperPower(int superPowerId) {
        var superPower = superPowerDao.find(superPowerId);
        return superHeroDao.getBySuperPower(superPower);
    }
    public SuperPower getSuperPower(int superPowerId) {
        return superPowerDao.find(superPowerId);
    }
    public List<SuperPower> getAllSuperPower(){return superPowerDao.getAll();}


    public List<SuperPower> getSuperPowerName(int superHeroId){
        SuperHero superHero = superHeroDao.find(superHeroId);
        List<SuperPower> superPowerList = superHero.getSuperPowers();
        return superPowerList;
    }

}
