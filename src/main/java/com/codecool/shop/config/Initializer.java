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
        SuperHero predator = new SuperHero("Predator", "Large, sapient and sentient humanoid creature.");
        superHeroDataStore.add(predator);
        SuperHero batBoy = new SuperHero("Bat Boy", "One of the strongest.");
        superHeroDataStore.add(batBoy);
        SuperHero usCaptain = new SuperHero("US Captain", "Has a shield.");
        superHeroDataStore.add(usCaptain);
        SuperHero ladyRed = new SuperHero("Lady Red", "Has a red dress.");
        superHeroDataStore.add(ladyRed);
        SuperHero blackVader = new SuperHero("Black Vader", "Has white head.");
        superHeroDataStore.add(blackVader);
        SuperHero mermaidPool = new SuperHero("Mermaid Pool", "Aquatic creature with the head and upper body of a female human and the tail of a fish.");
        superHeroDataStore.add(mermaidPool);
        SuperHero harleyClown = new SuperHero("Harley Clown", "The craziest female clown ever.");
        superHeroDataStore.add(harleyClown);
        SuperHero bluePokemon = new SuperHero("Blue Pokemon", "He is blue and can hold his hand.");
        superHeroDataStore.add(bluePokemon);
        SuperHero blueFighterTerminator = new SuperHero("Blue Fighter Terminator", "Very strong");
        superHeroDataStore.add(blueFighterTerminator);
        SuperHero ninjaFighter = new SuperHero("Ninja Fighter", "Fights with swords");
        superHeroDataStore.add(ninjaFighter);
        SuperHero deadlyRoss = new SuperHero("Deadly Ross", "Teach you to paint");
        superHeroDataStore.add(deadlyRoss);
        SuperHero assassin = new SuperHero("Assassin", "Takes off his hood when he is fighting");
        superHeroDataStore.add(assassin);
        SuperHero grayStatue = new SuperHero("Gray Statue", "Superfast, can't see when he moves");
        superHeroDataStore.add(grayStatue);
        SuperHero funnyBuzz = new SuperHero("Funny Buzz", "Can't scare you with his funny face");
        superHeroDataStore.add(funnyBuzz);
        SuperHero antBoy = new SuperHero("Ant Boy", "Not so small.");
        superHeroDataStore.add(antBoy);
        SuperHero greenCreature = new SuperHero("Green Creature", "She is green.");
        superHeroDataStore.add(greenCreature);
        SuperHero ironLady = new SuperHero("Iron Lady", "Strong.");
        superHeroDataStore.add(ironLady);

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
        joker.addCategory(pr);
        joker.addCategory(event);
        joker.addCategory(criminalJustice);
        scaryClown.addCategory(pr);
        scaryClown.addCategory(event);
        scaryClown.addCategory(criminalJustice);
        liberty.addCategory(pr);
        liberty.addCategory(event);
        liberty.addCategory(criminalJustice);
        littleFighter.addCategory(pr);
        littleFighter.addCategory(event);
        santa.addCategory(pr);
        santa.addCategory(event);
        marvelin.addCategory(pr);
        marvelin.addCategory(event);
        marvelin.addCategory(criminalJustice);
        predator.addCategory(pr);
        predator.addCategory(event);
        predator.addCategory(criminalJustice);
        batBoy.addCategory(pr);
        batBoy.addCategory(event);
        batBoy.addCategory(criminalJustice);
        usCaptain.addCategory(pr);
        usCaptain.addCategory(event);
        usCaptain.addCategory(criminalJustice);
        ladyRed.addCategory(pr);
        ladyRed.addCategory(event);
        blackVader.addCategory(pr);
        blackVader.addCategory(event);
        blackVader.addCategory(criminalJustice);
        mermaidPool.addCategory(pr);
        mermaidPool.addCategory(event);
        mermaidPool.addCategory(criminalJustice);
        harleyClown.addCategory(pr);
        harleyClown.addCategory(event);
        harleyClown.addCategory(criminalJustice);
        bluePokemon.addCategory(pr);
        bluePokemon.addCategory(event);
        blueFighterTerminator.addCategory(pr);
        blueFighterTerminator.addCategory(criminalJustice);
        ninjaFighter.addCategory(pr);
        ninjaFighter.addCategory(criminalJustice);
        deadlyRoss.addCategory(pr);
        deadlyRoss.addCategory(event);
        assassin.addCategory(pr);
        assassin.addCategory(criminalJustice);
        grayStatue.addCategory(pr);
        grayStatue.addCategory(event);
        grayStatue.addCategory(criminalJustice);
        funnyBuzz.addCategory(pr);
        funnyBuzz.addCategory(event);
        antBoy.addCategory(pr);
        antBoy.addCategory(event);
        antBoy.addCategory(criminalJustice);
        greenCreature.addCategory(pr);
        greenCreature.addCategory(event);
        greenCreature.addCategory(criminalJustice);
        ironLady.addCategory(pr);
        ironLady.addCategory(event);
        ironLady.addCategory(criminalJustice);


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
        houselander.addSuperPower(healing);
        houselander.addSuperPower(spitsFire);
        joker.addSuperPower(scare);
        scaryClown.addSuperPower(scare);
        scaryClown.addSuperPower(invisible);
        liberty.addSuperPower(invisible);
        liberty.addSuperPower(fast);
        liberty.addSuperPower(fly);
        littleFighter.addSuperPower(strong);
        santa.addSuperPower(invisible);
        santa.addSuperPower(mindControl);
        marvelin.addSuperPower(fly);
        marvelin.addSuperPower(fast);
        marvelin.addSuperPower(strong);
        predator.addSuperPower(strong);
        batBoy.addSuperPower(strong);
        usCaptain.addSuperPower(strong);
        usCaptain.addSuperPower(fast);
        ladyRed.addSuperPower(shapeShifting);
        ladyRed.addSuperPower(mindControl);
        blackVader.addSuperPower(strong);
        blackVader.addSuperPower(mindControl);
        mermaidPool.addSuperPower(underwaterControl);
        mermaidPool.addSuperPower(strong);
        harleyClown.addSuperPower(strong);
        harleyClown.addSuperPower(fast);
        harleyClown.addSuperPower(scare);
        bluePokemon.addSuperPower(mindControl);
        bluePokemon.addSuperPower(invisible);
        bluePokemon.addSuperPower(spitsFire);
        bluePokemon.addSuperPower(shapeShifting);
        blueFighterTerminator.addSuperPower(strong);
        blueFighterTerminator.addSuperPower(fast);
        blueFighterTerminator.addSuperPower(fly);
        ninjaFighter.addSuperPower(strong);
        ninjaFighter.addSuperPower(healing);
        deadlyRoss.addSuperPower(healing);
        deadlyRoss.addSuperPower(mindControl);
        assassin.addSuperPower(strong);
        assassin.addSuperPower(fast);
        assassin.addSuperPower(weatherControl);
        grayStatue.addSuperPower(fast);
        funnyBuzz.addSuperPower(scare);
        funnyBuzz.addSuperPower(fly);
        antBoy.addSuperPower(fly);
        antBoy.addSuperPower(strong);
        antBoy.addSuperPower(shapeShifting);
        grayStatue.addSuperPower(strong);
        grayStatue.addSuperPower(fast);
        grayStatue.addSuperPower(mindControl);
        ironLady.addSuperPower(strong);
        ironLady.addSuperPower(fast);

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
