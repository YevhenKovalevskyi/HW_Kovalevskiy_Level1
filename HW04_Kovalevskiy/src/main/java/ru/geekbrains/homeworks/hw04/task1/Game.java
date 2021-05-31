package ru.geekbrains.homeworks.hw04.task1;

import ru.geekbrains.homeworks.hw04.task1.field.Field;
import ru.geekbrains.homeworks.hw04.task1.player.Computer;
import ru.geekbrains.homeworks.hw04.task1.player.Player;
import ru.geekbrains.homeworks.hw04.task1.player.User;

public class Game {
    
    static void startGame(int fieldSize) {
        // greeting
        Game.printGreeting();
        
        // init
        String[][] cellValues = new String[fieldSize][fieldSize];
        Field field = new Field(fieldSize);
        
        // draw field
        field.drawField(cellValues);
        
        // players
        Player user = new User("Ivan", "X");
        Player computer = new Computer("IBM i386", "0");

        // run
        String result = Game.run(field, new Player[]{user, computer}, cellValues);
        
        // finish
        Game.printParting(result);
    }
    
    private static void printGreeting() {
        System.out.println("\n==================================================");
        System.out.println("Welcome to the TicTacToe game!");
        System.out.println("--------------------------------------------------");
        System.out.println("Rules: 2 players make 1 move, one after the other,");
        System.out.println("until the sequence of moves leads to victory.");
        System.out.println("--------------------------------------------------");
        System.out.println("If you want to exit the game - type \"exit\" !");
        System.out.println("==================================================\n");
        System.out.println("Start...\n");
    }
    
    private static String run(Field field, Player[] players, String[][] cellValues) {
        boolean isFinished = false;
        String result = "";
        
        do {
            for (Player player: players) {
                // player move
                cellValues = player.move(cellValues);
                
                // redraw field
                field.drawField(cellValues);

                // check for winner/draw
                if (isFinished = field.checkForWinner(cellValues, player.getSign())) {
                    result = String.format("The winner is: %s", player.getName());
                    break;
                } else if (isFinished = field.checkForDraw(cellValues)) {
                    result = "There is no winners. The result is draw!";
                    break;
                }
            }
        } while (!isFinished);
        
        return result;
    }
    
    private static void printParting(String result) {
        System.out.println("==================================================");
        System.out.println(result);
        System.out.println("==================================================");
    }
}
