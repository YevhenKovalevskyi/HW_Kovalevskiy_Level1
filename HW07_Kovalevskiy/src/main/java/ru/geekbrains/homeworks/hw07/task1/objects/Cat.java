package ru.geekbrains.homeworks.hw07.task1.objects;

import lombok.Setter;
import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;

/**
 * Plate Cat represents state and behavior of the entity "cat"
 *
 * @author e.kovalevskiy
 * @version 1.0
 */
@Slf4j
@Value
public class Cat {

    String name;
    int appetite;
    @NonFinal @Setter
    boolean full;
    
    /**
     * The method reduces the amount of food on the plate with the help of a cat
     *
     * @param plate of food for a cat
     */
    public void eat(Plate plate) {
        plate.reduceFood(appetite);
        setFull(true);
        log.info("The cat {} ate {} units of food from the plate.", name, appetite);
    }
}
