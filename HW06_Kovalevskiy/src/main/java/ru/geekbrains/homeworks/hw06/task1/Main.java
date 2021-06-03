package ru.geekbrains.homeworks.hw06.task1;

import lombok.extern.slf4j.Slf4j;
import ru.geekbrains.homeworks.hw06.task1.animals.Animal;
import ru.geekbrains.homeworks.hw06.task1.animals.Cat;
import ru.geekbrains.homeworks.hw06.task1.animals.Dog;
import ru.geekbrains.homeworks.hw06.task1.exceptions.ActionLimitExceededException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

@Slf4j
public class Main {
    
    public static void main(String[] args) {
        log.info("Start program...");

        Animal[] animals = {
                new Cat("Cat1"),
                new Cat("Cat2"),
                new Cat("Cat3"),
                new Cat("Cat4"),
                new Dog("Dog1"),
                new Dog("Dog2"),
        };
    
        Main.printAnimalsInfo(animals);

        log.info("End program.\n");
    }
    
    private static void printAnimalsInfo(Animal[] animals) {
        HashMap<String, Integer> animalsTotal = new HashMap<>();
    
        System.out.println();
        Arrays.stream(animals).forEach(animal -> {
            String animalName = animal.getName();
            String animalType = animal.getAnimalType();
            
            try {
                animal.run(new Random().nextInt(500));
            } catch (ActionLimitExceededException e) {
                Main.printExceptionInfo(animalName, e.getMessage());
            }
    
            try {
                animal.swim(new Random().nextInt(20));
            } catch (ActionLimitExceededException e) {
                Main.printExceptionInfo(animalName, e.getMessage());
            }
            
            Integer animalCount = animalsTotal.get(animalType);
            animalsTotal.put(animalType, (animalCount == null) ? 1 : ++animalCount);
            System.out.println("-");
        });
    
        animalsTotal.forEach((animal, count) -> System.out.printf("Animal [%s]: %d items\n", animal, count));
        System.out.println();
    }
    
    private static void printExceptionInfo(String animalName, String errorMessage) {
        log.error("Error detected for {}: {}.", animalName, errorMessage);
        System.out.printf("%s - limitation detected: %s\n", animalName, errorMessage);
    }
}
