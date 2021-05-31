package ru.geekbrains.homeworks.hw04.task1.field;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Field {
    
    private static final int DEFAULT_FIELD_SIZE = 3;
    
    private final int size;
    
    public Field(int size) {
        this.size = Math.max(size, Field.DEFAULT_FIELD_SIZE);
    }
    
    public void drawField(String[][] cellValues) {
        AtomicInteger vertical = new AtomicInteger();
        
        Arrays.stream(new Cell[this.size][this.size])
                .map(column -> {
                    vertical.incrementAndGet();
                    AtomicInteger horizontal = new AtomicInteger();
                    
                    return Arrays.stream(column)
                            .map(cell -> {
                                horizontal.incrementAndGet();
                                int v = vertical.get() - 1, h = horizontal.get() - 1;
                                
                                String value = (cellValues[v][h] != null) ? cellValues[v][h] : Cell.DEFAULT_CELL_VALUE;
                                String cellValue = new Cell(value).getValue();
                                cellValue = (h == 0) ? (" " + cellValue) : ((h == this.size - 1) ? (cellValue + " ") : cellValue);
                                
                                return cellValue;
                            }).toArray();
                })
                .forEach(item -> System.out.println(Arrays.toString(item).replace(",", "")));
        
        System.out.println();
    }
    
    public boolean checkForWinner(String[][] cellValues, String sign) {
        AtomicBoolean winner = new AtomicBoolean(false);
        
        // horizontal
        Arrays.stream(cellValues).forEach(column -> {
            if (Arrays.stream(column).allMatch(item -> (item != null && item.equals(sign)))) {
                winner.set(true);
            }
        });
    
        // vertical
        if (!winner.get()) {
            int fieldLength = cellValues.length;
            
            for (int i = 0; i < fieldLength; i++) {
                String[] row = new String[fieldLength];
                
                for (int j = 0; j < cellValues[i].length; j++) {
                    row[j] = cellValues[j][i];
                }
    
                if (Arrays.stream(row).allMatch(item -> (item != null && item.equals(sign)))) {
                    winner.set(true);
                }
            }
        }
        
        // diagonal 1
        if (!winner.get()) {
            winner.set(true);
            AtomicInteger vertical = new AtomicInteger();
            
            Arrays.stream(cellValues).forEach(column -> {
                vertical.incrementAndGet();
                AtomicInteger horizontal = new AtomicInteger();
        
                Arrays.stream(column).forEach(cell -> {
                    horizontal.incrementAndGet();
                    int v = vertical.get(), h = horizontal.get();
                    
                    if (v == h && (cell == null || !cell.equals(sign))) {
                        winner.set(false);
                    }
                });
            });
        }
    
        // diagonal 2
        if (!winner.get()) {
            winner.set(true);
            AtomicInteger vertical = new AtomicInteger();
        
            Arrays.stream(cellValues).forEach(column -> {
                vertical.incrementAndGet();
                AtomicInteger horizontal = new AtomicInteger();
            
                Arrays.stream(column).forEach(cell -> {
                    horizontal.incrementAndGet();
                    int v = vertical.get(), h = horizontal.get();
                
                    if (v == (column.length - h + 1) && (cell == null || !cell.equals(sign))) {
                        winner.set(false);
                    }
                });
            });
        }
        
        return winner.get();
    }
    
    public boolean checkForDraw(String[][] cellValues) {
        AtomicBoolean draw = new AtomicBoolean(true);
    
        Arrays.stream(cellValues).forEach(column -> {
            Arrays.stream(column).forEach(cell -> {
                if (cell == null) {
                    draw.set(false);
                }
            });
        });

        return draw.get();
    }
}
