package ru.geekbrains.homeworks.hw04.task1.player;

import lombok.Data;

@Data
public abstract class Player {
    
    private String name;
    private String sign;
    
    public abstract String[][] move(String[][] cellValues);
}
