package ru.geekbrains.homeworks.hw07.task1.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Plate Class represents state and behavior of the entity "plate"
 *
 * @author e.kovalevskiy
 * @version 1.0
 */
@Slf4j
@Data
@AllArgsConstructor
public class Plate {
    
    private int food;
    
    /**
     * The method reduces the amount of food on the plate
     *
     * @param amount of food eaten
     */
    public void reduceFood(int amount) {
        food -= amount;
        log.info("The amount of food on the plate has reduced by {} units.", amount);
    }
    
    /**
     * The method increases the amount of food on the plate
     *
     * @param amount of food added
     */
    public void increaseFood(int amount) {
        food += amount;
        log.info("The amount of food on the plate has increased by {} units.", amount);
    }
    
    /**
     * The method prints info about the amount of food on the plate
     */
    public void printFoodAmount() {
        System.out.printf("The current amount of food on the plate: %d.\n", food);
        log.info("The current amount of food on the plate: {}.", food);
    }
}
