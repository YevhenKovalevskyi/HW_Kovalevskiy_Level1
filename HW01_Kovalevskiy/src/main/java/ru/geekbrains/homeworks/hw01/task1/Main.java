package ru.geekbrains.homeworks.hw01.task1;

import lombok.extern.slf4j.Slf4j;
import ru.geekbrains.homeworks.hw01.helpers.NumbersHelper;
import ru.geekbrains.homeworks.hw01.utils.ConsoleColors;

import java.util.Arrays;

/**
 * Main Class represents homework #1 #task1
 *
 * @author e.kovalevskiy
 * @version 1.0
 */
@Slf4j
public class Main {
    
    public static void main(String[] args) {
        log.info("Start program...");
        
        // -1-
        System.out.println("printThreeWords:");
        Main.printThreeWords();
    
        // -2-
        String sumResult1 = Main.checkSumSign(1, 3);
        String sumResult2 = Main.checkSumSign(-10, 13);
        System.out.printf("\ncheckSumSign:\n%s\n%s\n", sumResult1, sumResult2);
    
        // -3-
        String colorResult1 = Main.getColor(111, false);
        String colorResult2 = Main.getColor(55, false);
        System.out.printf("\nprintColor:\n%s\n%s\n", colorResult1, colorResult2);
    
        // -4-
        String compareResult1 = Main.compareNumbers(123, 321);
        String compareResult2 = Main.compareNumbers(0, -123);
        System.out.printf("\ncompareNumbers:\n%s\n%s\n", compareResult1, compareResult2);
    
        log.info("End program.\n");
    }
    
    /**
     * The method prints some String data from array
     */
    private static void printThreeWords() {
        String[] words = {"Orange", "Banana", "Apple"};
        Arrays.asList(words).forEach(System.out::println);
        
        log.info("Print the array: " + Arrays.toString(words));
    }
    
    /**
     * The method gets the sign of the sum of integer numbers
     *
     * @param a int param
     * @param b int param
     * @return String sign of the sum
     */
    public static String checkSumSign(int a, int b) {
        String result = (a + b) > 0 ? "Сумма положительная" : "Сумма отрицательная";
        
        log.info("Got the sign of the sum: " + result);
        
        return result;
    }
    
    /**
     * The method gets a color by an integer number
     *
     * @param number int param
     * @return String color
     */
    public static String getColor(int number, boolean onlyColor) {
        String result;
        
        if (NumbersHelper.isLessThanNumber(number, 0, false)) {
            result = ConsoleColors.RED + "Красный" + ConsoleColors.RESET;
        } else if (NumbersHelper.isBetweenInterval(number, 1, 100, false)) {
            result = ConsoleColors.YELLOW + "Желтый" + ConsoleColors.RESET;
        } else {
            result = ConsoleColors.GREEN + "Зеленый" + ConsoleColors.RESET;
        }
        
        String cleanResult = result.replaceAll("[^А-Яа-я]", "");
    
        log.info("Got the color: " + cleanResult);
        
        return onlyColor ? cleanResult : result;
    }
    
    /**
     * The method gets the result of comparing integers
     *
     * @param a int param
     * @param b int param
     * @return String result of comparing integers
     */
    public static String compareNumbers(int a, int b) {
        String result = (NumbersHelper.isMoreThanNumber(a, b, false)) ? "a >= b" : "a < b";
    
        log.info("Got the result of comparing integers: " + result);
        
        return result;
    }
}
