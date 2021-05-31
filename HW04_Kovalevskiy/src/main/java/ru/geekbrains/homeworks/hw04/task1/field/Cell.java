package ru.geekbrains.homeworks.hw04.task1.field;

import lombok.Value;

import java.util.Arrays;

@Value
public class Cell {
    
    public static final String DEFAULT_CELL_VALUE = "\u2014";
    public static final String[] POSSIBLE_VALUE = {"X", "0", "\u2014"};
    
    String value;
    
    public Cell(String value) {
        this.value = Arrays.asList(Cell.POSSIBLE_VALUE).contains(value) ? value : Cell.DEFAULT_CELL_VALUE;
    }
}
