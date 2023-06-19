package com.codecool.battleship;

import com.codecool.battleship.display.Display;
import com.codecool.battleship.game.Game;
import com.codecool.battleship.input.Input;

public class Battleship {
    private Display display;
    private Input inputs;
    private Game game;
    public boolean run;

    private Battleship() {
        display = new Display();
        inputs = new Input();
        game = new Game();
        run = true;
    }

    private void mainMenu(){
        while (run){
            display.displayTitle();
            display.displayMenu();
            int chosenMode = inputs.userInt();
            switch (chosenMode){
                case 0:
                    run = false;
                    break;
                case 1:
                    game.newGame(null);
                    break;
                case 2:
                    game.newGame("Unbeatable AI");
                    break;
                case 3:
                    System.out.println("\uD83D\uDC49\uD83C\uDFFBHow to play?");
                    GameRules.gameRules();
                    break;
                default:
                    display.wrongInput();
                    mainMenu();
            }
        }
    }

    public static void main(String args[]){
        new Battleship().mainMenu();
    }
}
