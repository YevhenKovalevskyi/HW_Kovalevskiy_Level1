package ru.geekbrains.homeworks.hw04.task1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    
    public static void main(String[] args) {
        log.info("Start program...");
        
        int fieldSize = 4;
        
        Game.startGame(fieldSize);

        log.info("End program.\n");
    }
}
