package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SuperPowerDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.SuperPower;

import java.util.List;

public class ProductService{
    private ProductDao productDao;
    private ProductCategoryDao productCategoryDao;
    private SuperPowerDao superPowerDao;
    public ProductService(ProductDao productDao, ProductCategoryDao productCategoryDao, SuperPowerDao superPowerDao) {
        this.productDao = productDao;
        this.productCategoryDao = productCategoryDao;
        this.superPowerDao = superPowerDao;
    }

    public ProductCategory getProductCategory(int categoryId){
        return productCategoryDao.find(categoryId);
    }

    public List<Product> getProductsForCategory(int categoryId){
        var category = productCategoryDao.find(categoryId);
        return productDao.getBy(category);
    }

    public List<Product> getProductsForSuperPower(int superPowerId) {
        var superPower = superPowerDao.find(superPowerId);
        return productDao.getBySuperPower(superPower);
    }
    public SuperPower getSuperPower(int superPowerId) {
        return superPowerDao.find(superPowerId);
    }

    public List<ProductCategory> getAllProductCategory() {
        return productCategoryDao.getAll();
    }
    public List<SuperPower> getAllSuperPower(){return superPowerDao.getAll();}

}
