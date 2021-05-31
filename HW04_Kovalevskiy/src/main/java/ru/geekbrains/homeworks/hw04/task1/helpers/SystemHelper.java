package ru.geekbrains.homeworks.hw04.task1.helpers;

public class SystemHelper {
    
    /**
     * Exit from the program
     */
    public static void exitProgram() {
        System.exit(0);
    }
    
    /**
     * Exit from the program
     *
     * @param message explanation
     */
    public static void exitProgramWithMessage(String message) {
        System.out.printf("-> %s\n\n", message);
        System.exit(0);
    }
}
