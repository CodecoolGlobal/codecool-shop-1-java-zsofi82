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
        SuperHeroDao superHeroDataStore = SuperHeroDaoMem.getInstance();
        SuperPowerDao superPowerDataStore = SuperPowerDaoMem.getInstance();

        //setting up a new supplier
        SuperHero houselander = new SuperHero("HouseLander", "Bring you home from everywhere to everywhere safely.");
        superHeroDataStore.add(houselander);
        SuperHero joker = new SuperHero("Joker", "Make bad things");
        superHeroDataStore.add(joker);
        SuperHero scaryClown = new SuperHero("ScaryClown", "Can scare you!");
        superHeroDataStore.add(scaryClown);
        SuperHero liberty = new SuperHero("Liberty", "Save you from the trouble!");
        superHeroDataStore.add(liberty);
        SuperHero littleFighter = new SuperHero("Little fighter", "Be aware of Little Fighter.");
        superHeroDataStore.add(littleFighter);
        SuperHero santa = new SuperHero("Santa", "Make your Christmas special");
        superHeroDataStore.add(santa);
        SuperHero marvelin = new SuperHero("Lady Marvelin", "You know her.");
        superHeroDataStore.add(marvelin);

        //setting up a new product category

        ProductCategory pr = new ProductCategory("PR", "All", "All Sup is available for PR and marketing advertisements if it fits to their super powers or image.", new BigDecimal("300"), "USD");
        productCategoryDataStore.add(pr);
        ProductCategory event = new ProductCategory("Event", "All", "Organise a big event, a birthday party, a company event..., depend on it's theme, place, conditions our Sups are happy to make your event even more prominent.", new BigDecimal("300"), "USD");

        //ProductCategory event = new ProductCategory("Event", "Family", "The perfect choice for everyone and for every services. Entertain families, save from and catches bad guys.");
        productCategoryDataStore.add(event);
        ProductCategory criminalJustice = new ProductCategory("Criminal justice", "UpTo18", "To catch a thief, bring peace to a family fight, keep peace on a big sport event... call one of our Sups and they will be your guarantee for piece of mind.", new BigDecimal("300"), "USD");
        productCategoryDataStore.add(criminalJustice);

        //Add categories to Heroes
        houselander.addCategory(pr);
        houselander.addCategory(event);
        houselander.addCategory(criminalJustice);
        joker.addCategory(event);
        scaryClown.addCategory(event);
        scaryClown.addCategory(criminalJustice);
        liberty.addCategory(event);
        liberty.addCategory(pr);
        liberty.addCategory(criminalJustice);
        littleFighter.addCategory(event);
        santa.addCategory(event);
        santa.addCategory(pr);
        marvelin.addCategory(criminalJustice);


        //setting up a new superPower
        SuperPower fly = new SuperPower("Fly", "Can fly");
        superPowerDataStore.add(fly);
        SuperPower scare = new SuperPower("Scary", "Can scare you");
        superPowerDataStore.add(scare);
        SuperPower invisible = new SuperPower("Invisible", "Can be invisble");
        superPowerDataStore.add(invisible);
        SuperPower fast = new SuperPower("Fast", "Can heal him-/herself");
        superPowerDataStore.add(fast);
        SuperPower spitsFire = new SuperPower("Spits fire", "Can spits fire");
        superPowerDataStore.add(spitsFire);
        SuperPower strong = new SuperPower("Super strong", "Can hold everything");
        superPowerDataStore.add(strong);
        SuperPower shapeShifting = new SuperPower("Shape shifting", "Able to change his/here shape to any other form.");
        superPowerDataStore.add(shapeShifting);
        SuperPower healing = new SuperPower("Healing", "Able to heal her/his wounds.");
        superPowerDataStore.add(healing);
        SuperPower underwaterControl = new SuperPower("Underwater control", "Able to breathe underwater.");
        superPowerDataStore.add(underwaterControl);
        SuperPower weatherControl = new SuperPower("Weather control", "Able to change weather.");
        superPowerDataStore.add(weatherControl);
        SuperPower mindControl = new SuperPower("Mind control", "Control the minds of everyone around them.");
        superPowerDataStore.add(mindControl);


        houselander.addSuperPower(fly);
        houselander.addSuperPower(strong);
        houselander.addSuperPower(fast);
        joker.addSuperPower(scare);
        scaryClown.addSuperPower(scare);
        liberty.addSuperPower(invisible);
        liberty.addSuperPower(fast);
        liberty.addSuperPower(fly);
        littleFighter.addSuperPower(strong);
        santa.addSuperPower(invisible);
        marvelin.addSuperPower(fly);
        marvelin.addSuperPower(fast);
        marvelin.addSuperPower(strong);

        //setting up products and printing it

        productDataStore.add(new Product("Houselander", new BigDecimal("149.9"), "USD", "Great price with extra discount by DirtyDevs shoe store.", pr, houselander));
        productDataStore.add(new Product("Joker", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", pr, joker));
        productDataStore.add(new Product("ScaryClown", new BigDecimal("119"), "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", pr, scaryClown));
        productDataStore.add(new Product("Liberty", new BigDecimal("89"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", criminalJustice, liberty));
        productDataStore.add(new Product("Liberty", new BigDecimal("89"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", pr, liberty));
        productDataStore.add(new Product("little Fighter", new BigDecimal("149.9"), "USD", "Great price with extra discount by DirtyDevs shoe store.", criminalJustice, littleFighter));
        productDataStore.add(new Product("Santa", new BigDecimal("149.9"), "USD", "Great price with extra discount by DirtyDevs shoe store.", event, santa));
        productDataStore.add(new Product("Lady Marvelin", new BigDecimal("149.9"), "USD", "Great price with extra discount by DirtyDevs shoe store.", criminalJustice, marvelin));


    }
}
