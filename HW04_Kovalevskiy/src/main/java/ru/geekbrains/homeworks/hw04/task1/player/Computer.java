package ru.geekbrains.homeworks.hw04.task1.player;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.Random;

@EqualsAndHashCode(callSuper = true)
@Value
public class Computer extends Player {
    
    String name;
    String sign;
    
    public String[][] move(String[][] cellValues) {
        System.out.printf("Your turn, %s...\n", this.getName());
    
        boolean emptyValue;
        int fieldLength = cellValues.length;
    
        do {
            int verticalValue = new Random().nextInt(fieldLength);
            int horizontalValue = new Random().nextInt(fieldLength);
        
            if (emptyValue = (cellValues[horizontalValue][verticalValue] == null)) {
                cellValues[horizontalValue][verticalValue] = this.sign;
                System.out.printf("-> v:%d - h:%d \n", verticalValue + 1, horizontalValue + 1);
                System.out.println("-> OK! Accepted!\n");
            }
        } while (!emptyValue);
        
        return cellValues;
    }
}
