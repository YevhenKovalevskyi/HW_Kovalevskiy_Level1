package ru.geekbrains.homeworks.hw04.task1.services;

import ru.geekbrains.homeworks.hw04.task1.helpers.NumbersHelper;
import ru.geekbrains.homeworks.hw04.task1.helpers.ScannerHelper;

import java.util.Scanner;

/**
 * ConsoleService Class represents methods for getting data from the console
 *
 * @author e.kovalevskiy
 * @version 1.0
 */
public class ConsoleService {
    
    /**
     * The method takes, validates and returns number data from the console
     *
     * @param in Scanner instance
     * @return integer console data
     */
    public static int getConsoleNumberData(Scanner in, String type, int lower, int upper) {
        boolean isCorrectInt;
        int number = 0;
    
        do {
            System.out.printf("-> Enter a value %s from %d to %d: ", type, lower, upper);
            isCorrectInt = in.hasNextInt();
        
            if (isCorrectInt) {
                number = in.nextInt();
            
                if (!NumbersHelper.isBetweenInterval(number, lower, upper, false)) {
                    isCorrectInt = false;
                    System.out.println("-> NOT OK! Value is out of boundaries.");
                }
            } else {
                ScannerHelper.checkForExitScannerNext(in);
                System.out.println("-> NOT OK! Value is incorrect.");
                in.nextLine();
            }
        } while (!isCorrectInt);
        
        return number;
    }
}
