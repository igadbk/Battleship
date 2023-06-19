package com.codecool.battleship;

public class GameRules {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";
    public static final String WHITE_BRIGHT = "\033[0;97m";
    public static final String BLUE_BACKGROUND = "\033[44m";

    public static void gameRules() {
        StringBuilder gameRules = new StringBuilder();
        gameRules.append("\n" + BLUE_BACKGROUND + "\n" + ANSI_RESET)
                .append(BLUE_BOLD_BRIGHT)
                .append("\n        The goal of \"BattleShip\" is to sink all your opponent's ships")
                .append(WHITE_BRIGHT)
                .append("\n\n")
                .append("Step 1: Place all your ships on the board. you can do it manually or automatically.\n")
                .append("Step 2: The game starts now - choose the squares on your turn where you want to hit.\n" +
                        "Step 3: The winner is the one who shoots down all enemy ships first!\n")
                .append("\n")
                .append("\n" + BLUE_BACKGROUND + "\n" + ANSI_RESET);

        System.out.println(gameRules);
    }

}
