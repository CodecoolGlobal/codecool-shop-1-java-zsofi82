package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SuperPowerDao;
import com.codecool.shop.dao.SuperHeroDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SuperPowerDaoMem;
import com.codecool.shop.dao.implementation.SuperHeroDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.SuperPower;
import com.codecool.shop.model.SuperHero;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SuperHeroDao supplierDataStore = SuperHeroDaoMem.getInstance();
        SuperPowerDao superPowerDataStore = SuperPowerDaoMem.getInstance();

        //setting up a new supplier
        SuperHero houselander = new SuperHero("HouseLander", "Bring you home from everywhere to everywhere safely.");
        supplierDataStore.add(houselander);
        SuperHero joker = new SuperHero("Joker", "Make bad things");
        supplierDataStore.add(joker);
        SuperHero scaryClown = new SuperHero("ScaryClown", "Can scare you!");
        supplierDataStore.add(scaryClown);
        SuperHero liberty = new SuperHero("Liberty", "Save you from the trouble!");
        supplierDataStore.add(liberty);
        SuperHero houselander2 = new SuperHero("HouseLander 2", "Bring you home from everywhere to everywhere safely.");
        supplierDataStore.add(houselander2);
        SuperHero flyerHouselander = new SuperHero("Flyer Houselander", "Bring you home from everywhere to everywhere safely.");
        supplierDataStore.add(flyerHouselander);
        SuperHero invisibleHouselander = new SuperHero("Invisible Houselander", "Bring you home from everywhere to everywhere safely.");
        supplierDataStore.add(invisibleHouselander);
        /*
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierDataStore.add(amazon);
        Supplier lenovo = new Supplier("Lenovo", "Computers");
        supplierDataStore.add(lenovo);
         */

        //setting up a new product category
        ProductCategory sup = new ProductCategory("Superhero", "Family", "The perfect choice for everyone and for every services. Entertain families, save from and catches bad guys.");
        productCategoryDataStore.add(sup);
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(tablet);
        ProductCategory event = new ProductCategory("Event", "Family", "The perfect choice for everyone and for every services. Entertain families, save from and catches bad guys.");
        productCategoryDataStore.add(event);
        ProductCategory criminalJustice = new ProductCategory("Criminal justice", "Family", "The perfect choice for everyone and for every services. Entertain families, save from and catches bad guys.");
        productCategoryDataStore.add(criminalJustice);
        //ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        //productCategoryDataStore.add(tablet);

        //setting up a new superPower
        SuperPower fly = new SuperPower("Flyer", "Can fly");
        superPowerDataStore.add(fly);
        SuperPower scare = new SuperPower("Scary", "Can scare you");
        superPowerDataStore.add(fly);
        SuperPower invisible = new SuperPower("Invisible", "Can be invisble");
        superPowerDataStore.add(invisible);

        //setting up products and printing it
        productDataStore.add(new Product("Houselander", new BigDecimal("149.9"), "USD", "Great price with extra discount by DirtyDevs shoe store.", sup, houselander, fly));
        productDataStore.add(new Product("Joker", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", sup, joker, scare));
        productDataStore.add(new Product("ScaryClown", new BigDecimal("119"), "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", sup, scaryClown, scare));
        productDataStore.add(new Product("Liberty", new BigDecimal("89"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", sup, liberty, fly));
        System.out.println(productDataStore.getAll());
        productDataStore.add(new Product("Houselander 2", new BigDecimal("149.9"), "USD", "Great price with extra discount by DirtyDevs shoe store.", criminalJustice, houselander2, fly));
        productDataStore.add(new Product("Flyer Houselander", new BigDecimal("149.9"), "USD", "Great price with extra discount by DirtyDevs shoe store.", event, flyerHouselander, fly));
        productDataStore.add(new Product("Invisible Houselander", new BigDecimal("149.9"), "USD", "Great price with extra discount by DirtyDevs shoe store.", criminalJustice, invisibleHouselander, invisible));

        //        productDataStore.add(new Product("Amazon Fire", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon));
//        productDataStore.add(new Product("Lenovo IdeaPad Miix 700", new BigDecimal("479"), "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", tablet, lenovo));
//        productDataStore.add(new Product("Amazon Fire HD 8", new BigDecimal("89"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", tablet, amazon));
        System.out.println(productDataStore.getAll());
    }
}
