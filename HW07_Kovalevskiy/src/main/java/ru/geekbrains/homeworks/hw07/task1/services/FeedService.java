package ru.geekbrains.homeworks.hw07.task1.services;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import ru.geekbrains.homeworks.hw07.task1.objects.Cat;
import ru.geekbrains.homeworks.hw07.task1.objects.Plate;
import ru.geekbrains.homeworks.hw07.task1.exceptions.ConditionsNotPassedException;

import java.util.Arrays;

/**
 * FeedService Class represents the logic of interaction between entities during feeding
 *
 * @author e.kovalevskiy
 * @version 1.0
 */
@Slf4j
@Value
public class FeedService {

    Cat[] cats;
    Plate plate;
    
    /**
     * The method tries to feed the cat
     *
     * @param catName to feed
     */
    public void feedOneCat(String catName) {
        Cat cat = getOneCat(catName);
        
        try {
            System.out.printf("\n - Cat \"%s\" is trying to eat...", catName);
            /* 1. Preliminary checks */
            checkForConditions(cat, true);
    
            /* 2. Feed the cat */
            cat.eat(plate);
            System.out.printf("\n - \"%s\" has eaten %d units of food.\n\n", catName, cat.getAppetite());
        } catch (ConditionsNotPassedException e) {
            String errorMessage = e.getMessage();
            
            log.error("Conditions error detected: {}", errorMessage);
            System.out.printf("\n - %s", errorMessage);
            System.out.printf("\n - \"%s\" is hungry.\n\n", catName);
        }
    
        showFoodAvailabilityInformation();
    }
    
    /**
     * The method tries to feed all cats
     */
    public void feedAllCats() {
        Arrays.stream(cats).forEach(cat -> {
            String catName = cat.getName();
            
            try {
                System.out.printf("\n - Cat \"%s\" is trying to eat...", catName);
                /* 1. Preliminary checks */
                checkForConditions(cat, false);
        
                /* 2. Feed the cat */
                cat.eat(plate);
                System.out.printf("\n - \"%s\" has eaten %d units of food.", catName, cat.getAppetite());
                System.out.printf("\n - \"%s\" is full.\n\n", catName);
            } catch (ConditionsNotPassedException e) {
                String errorMessage = e.getMessage();
        
                log.error("Conditions error detected: {}", errorMessage);
                System.out.printf("\n - %s", errorMessage);
                System.out.printf("\n - \"%s\" is hungry.\n\n", catName);
            }
    
            showFoodAvailabilityInformation();
        });
    }
    
    /**
     * The method prints information about food amount
     */
    public void showFoodAvailabilityInformation() {
        plate.printFoodAmount();
    }
    
    /**
     * The method gets one cat from an array
     *
     * @param catName to get
     *
     * @return Cat object of null
     */
    private Cat getOneCat(String catName) {
        return Arrays.stream(cats).filter(cat -> catName.equals(cat.getName())).findAny().orElse(null);
    }
    
    /**
     * The method tries to pass all conditions
     *
     * @param cat to feed
     * @param checkCatExistence in case of cat is null
     */
    private void checkForConditions(Cat cat, boolean checkCatExistence) throws ConditionsNotPassedException {
        int amountOfFood = plate.getFood();
        
        if (checkCatExistence) {
            /* 1. Checking for the existence of a cat */
            if (cat == null) {
                throwConditionsException("Eating failed. The cat was not found. No one to feed.");
            }
        }
        
        /* 2. Checking for the existence of a food */
        if (amountOfFood == 0) {
            throwConditionsException("Eating failed. The plate is empty. There is nothing to feed.");
        }
        
        /* 3. Checking the cat's satiety */
        if (cat.isFull()) {
            throwConditionsException("Eating failed. The cat is full. There is no need to feed.");
        }
        
        /* 4. Checking the ratio of food and appetite */
        if (cat.getAppetite() > amountOfFood) {
            throwConditionsException("Eating failed. The cat's appetite is greater than the amount of food.");
        }
    }
    
    /**
     * The method throws an exception
     *
     * @param message error
     */
    private void throwConditionsException(String message) throws ConditionsNotPassedException {
        throw new ConditionsNotPassedException(message);
    }
}
