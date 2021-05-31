package ru.geekbrains.homeworks.hw04.task1.player;

import lombok.EqualsAndHashCode;
import lombok.Value;
import ru.geekbrains.homeworks.hw04.task1.services.ConsoleService;

import java.util.Scanner;

@EqualsAndHashCode(callSuper = true)
@Value
public class User extends Player {
    
    String name;
    String sign;
    
    @Override
    public String[][] move(String[][] cellValues) {
        System.out.printf("Your turn, %s...\n", this.getName());
    
        boolean emptyValue;
        int fieldLength = cellValues.length;
        
        Scanner in = new Scanner(System.in);
        
        do {
            int verticalValue = ConsoleService.getConsoleNumberData(in, "horizontally", 1, fieldLength) - 1;
            int horizontalValue = ConsoleService.getConsoleNumberData(in, "vertically", 1, fieldLength) - 1;

            if (emptyValue = (cellValues[horizontalValue][verticalValue] == null)) {
                cellValues[horizontalValue][verticalValue] = this.sign;
                System.out.println("-> OK! Accepted!\n");
            } else {
                System.out.println("-> NOT OK! The position is already taken. Try again.");
            }
        } while (!emptyValue);
        
        return cellValues;
    }
}
