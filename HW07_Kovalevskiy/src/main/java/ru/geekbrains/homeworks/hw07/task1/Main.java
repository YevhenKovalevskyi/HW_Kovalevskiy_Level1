package ru.geekbrains.homeworks.hw07.task1;

import lombok.extern.slf4j.Slf4j;
import ru.geekbrains.homeworks.hw07.task1.objects.Cat;
import ru.geekbrains.homeworks.hw07.task1.objects.Plate;
import ru.geekbrains.homeworks.hw07.task1.services.FeedService;

/**
 * Main Class represents homework #7 #task1
 *
 * @author e.kovalevskiy
 * @version 1.0
 */
@Slf4j
public class Main {
    
    public static void main(String[] args) {
        Main.header();
    
        Plate plate = new Plate(100);
        Cat[] cats = {
                new Cat("Oliver", 25, false),
                new Cat("Leo", 10, false),
                new Cat("Milo", 35, false),
                new Cat("Charlie", 20, false),
                new Cat("Simba", 25, false),
        };
        FeedService feedService = new FeedService(cats, plate);
    
        feedService.showFoodAvailabilityInformation();
        feedService.feedAllCats();
        /*feedService.feedOneCat("Milo"); - also works! */
        
        Main.footer();
    }
    
    private static void header() {
        log.info("Start program...");
        System.out.println("----------------------------------------------");
        System.out.println("The relationship of the cat and the plate.\n");
    }
    
    private static void footer() {
        System.out.println("\nThat's all!");
        System.out.println("----------------------------------------------");
        log.info("End program.\n");
    }
}
