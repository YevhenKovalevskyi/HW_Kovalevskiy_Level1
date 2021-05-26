package ru.geekbrains.homeworks.hw02.task1;

import lombok.extern.slf4j.Slf4j;
import ru.geekbrains.homeworks.hw02.helpers.NumbersHelper;

import java.util.Collections;

@Slf4j
public class Main {
    
    public static void main(String[] args) {
        log.info("Start program...");
    
        // -1-
        String sumResult1 = Main.checkIfSumBelongsToInterval(1, 11, 10, 20);
        String sumResult2 = Main.checkIfSumBelongsToInterval(-10, 13, 0, 2);
        System.out.printf("\ncheckIfSumBelongsToInterval:\n%s\n%s\n", sumResult1, sumResult2);
    
        // -2-
        String signResult1 = Main.checkNumberSign(1);
        String signResult2 = Main.checkNumberSign(-10);
        String signResult3 = Main.checkNumberSign(0);
        System.out.printf("\ncheckNumberSign:\n%s\n%s\n%s\n", signResult1, signResult2, signResult3);
    
        // -3-
        String negativeResult1 = Main.isNumberNegative(1);
        String negativeResult2 = Main.isNumberNegative(-10);
        System.out.printf("\nisNumberNegative:\n%s\n%s\n", negativeResult1, negativeResult2);
    
        // -4-
        String repeatResult1 = Main.repeatNumberTimes("string", 4);
        String repeatResult2 = Main.repeatNumberTimes("*|*", 7);
        System.out.printf("\nprintNumberTimes:\n%s\n%s\n", repeatResult1, repeatResult2);
    
        // -5-
        String leapResult1 = Main.isLeapYear(1);
        String leapResult2 = Main.isLeapYear(700);
        String leapResult3 = Main.isLeapYear(800);
        String leapResult4 = Main.isLeapYear(20);
        System.out.printf("\nisLeapYear:\n%s\n%s\n%s\n%s\n", leapResult1, leapResult2, leapResult3, leapResult4);
    
        log.info("End program.\n");
    }
    
    /**
     * The method checks if the sum of integer numbers belongs to the interval
     *
     * @param a arbitrary integer
     * @param b arbitrary integer
     * @param leftBorder left boundary
     * @param rightBorder right boundary
     * @return String result of checking
     */
    public static String checkIfSumBelongsToInterval(int a, int b, int leftBorder, int rightBorder) {
        if (leftBorder >= rightBorder) {
            log.error("Interval boundaries [{}:{}] are incorrect!", leftBorder, rightBorder);
            throw new IllegalArgumentException("Interval boundaries are incorrect!");
        }
        
        int sum = a + b;
        String result = NumbersHelper.isBetweenInterval(sum, leftBorder, rightBorder, false) ? "true" : "false";

        log.info("checkIfSumBelongsToInterval: {} <= {} <= {} - {}", leftBorder, sum, rightBorder, result);
        
        return result;
    }
    
    /**
     * The method gets the sign of the integer number
     *
     * @param number arbitrary integer
     * @return String sign of the number
     */
    public static String checkNumberSign(int number) {
        String[] signs = {"negative", "zero", "positive"};
        int index = NumbersHelper.checkNumberSign(number);
        
        log.info("Got the sign of the number {}: {}", number, signs[index]);
        
        return signs[index];
    }
    
    /**
     * The method tests a number for negative
     *
     * @param number arbitrary integer
     * @return String is the number negative
     */
    public static String isNumberNegative(int number) {
        int index = NumbersHelper.checkNumberSign(number);
        String result = (index == 0) ? "true" : "false";
        
        log.info("Got if number is negative {}: {}", number, result);
        
        return result;
    }
    
    /**
     * The method prints a string number times
     *
     * @param str arbitrary string for repetition
     * @param number arbitrary integer of repetitions
     * @return String result of repeating
     */
    public static String repeatNumberTimes(String str, int number) {
        if (number <= 0) {
            log.error("Number of repetitions {} is incorrect!", number);
            throw new IllegalArgumentException("Number of repetitions is incorrect!");
        }
    
        String result = String.join("", Collections.nCopies(number, str));
        log.info("Got string {} repeated {} times: {}", str, number, result);
        
        return result;
    }
    
    /**
     * The method checks if the year is a leap year
     * @param year arbitrary integer
     * @return String result of checking
     */
    public static String isLeapYear(int year) {
        if (year <= 0) {
            log.error("Year {} is incorrect!", year);
            throw new IllegalArgumentException("Year is incorrect!");
        }
        
        String result = (year % 400 == 0)
                ? "високосный"
                : ((year % 100 != 0 && year % 4 == 0) ? "високосный" : "не високосный");
    
        log.info("Got the check result for a leap year: {} is {}", year, result);
        
        return result;
    }
}
