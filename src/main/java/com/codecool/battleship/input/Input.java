package com.codecool.battleship.input;

import com.codecool.battleship.Util;
import com.codecool.battleship.display.Display;
import com.codecool.battleship.ship.Compass;

import java.util.Random;
import java.util.Scanner;

public class Input {

    private final Display display = new Display();

    Scanner userInput = new Scanner(System.in);

    public String userName() {
        String input = userInput.nextLine();
        if (isValidNameInput(input)) {
            return input;
        }
        return userName();
    }

    public int[] getDirection() {
        String input = userInput.nextLine();
        int[] direction;
        switch (input.toLowerCase()) {
            case "n":
                direction = Compass.NORTH.getCoo();
                return direction;
            case "s":
                direction = Compass.SOUTH.getCoo();
                return direction;
            case "e":
                direction = Compass.EAST.getCoo();
                return direction;
            case "w":
                direction = Compass.WEST.getCoo();
                return direction;
            default:
                display.wrongInput();
                return getDirection();
        }
    }

    public int userInt() {
        String input = userInput.nextLine();
        while (!isInt(input)) {
            input = userInput.nextLine();
        }
        return Integer.parseInt(input);
    }

    private boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (
                NumberFormatException e) {
            display.wrongInput();
            return false;
        }
    }

    public int[] userCoo() {
        char[] abc = Util.getLetters(10, false);
        String move = userInput.nextLine();
        char[] startingCord = move.toCharArray();
        if (!isValidCooInput(startingCord)) {
            display.wrongInput();
            return userCoo();
        }
        int firstCoo = convertFirstCord(startingCord[0], abc);
        int secCoo = convertSecondCord(startingCord, abc);
        if (firstCoo < 0 || secCoo < 0) {
            display.wrongInput();
            return userCoo();
        }
        int[] startingCoo = new int[2];
        startingCoo[1] = firstCoo;
        startingCoo[0] = secCoo;
        return startingCoo;
    }

    public int convertFirstCord(char cord, char[] abc) {
        cord = Character.toLowerCase(cord);
        int firstCord = 0;
        boolean found = false;
        for (int i = 0; i < abc.length; i++) {
            if (abc[i] == cord) {
                firstCord = i;
                found = true;
            }
        }
        if (found) {
            return firstCord;
        }
        return -1;
    }


    public int convertSecondCord(char[] cords, char[] abc) {
        String convertCord;
        if (cords.length > 2) {
            convertCord = String.valueOf(cords[1]) + cords[2];
        } else {
            convertCord = String.valueOf(cords[1]);
        }
        int coo = Integer.parseInt(convertCord);
        if (coo < abc.length) {
            return coo;
        }
        return -1;
    }

    public boolean isValidCooInput(char[] coords) {
        if (coords.length < 2 || coords.length > 3) {
            return false;
        } else if (coords.length == 3) {
            return Character.isDigit(coords[1]) && Character.isDigit(coords[2]);
        } else return Character.isDigit(coords[1]);
    }

    public boolean isValidNameInput(String name) {
        return name.length() <= 10;
    }

    public int[] randomCoo(){
        int[] startingCoo = new int[2];
        startingCoo[0] = new Random().nextInt(10);
        startingCoo[1] = new Random().nextInt(10);
        return startingCoo;
    }

    public int[] randomDir(){
        return Compass.values()[new Random().nextInt(Compass.values().length)].getCoo();
    }
}