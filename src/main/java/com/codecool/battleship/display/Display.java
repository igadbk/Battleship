package com.codecool.battleship.display;

import com.codecool.battleship.Util;
import com.codecool.battleship.player.Player;
import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.square.Square;

import java.io.File;
import java.io.IOException;

public class Display {

    public void displayTitle() {
        try {
            File fileTitle = new File("src/main/resources/gametitle.txt");
            Util.readFile(fileTitle);
        } catch (IOException ioe) {
            System.out.println("File does not exist!");
        }
    }
    public void displayMenu(){
        System.out.println("1️⃣Player vs. Player \uD83C\uDF1A\uD83C\uDF1D");
        System.out.println("2️⃣Player vs. Unbeatable AI \uD83C\uDF1D\uD83D\uDDA5");
        System.out.println("3️⃣How to play?\uD83D\uDCD4");
        System.out.println("0️⃣Exit\uD83D\uDEB7");
    }

    public void placementSelection(){
        System.out.println("1️⃣Manual placement");
        System.out.println("2️⃣Automatic placement");
    }

    public void wrongInput(){
        System.out.println("Invalid input, try again!");
    }

    public void clearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void displayBoard(Square[][] ocean, boolean isHidden){
        String header = Util.makeHeader(ocean.length);
        System.out.println(header);
        for (int i = 0; i < ocean.length; i++){
            StringBuilder row;
            if (i < 10){
                row = new StringBuilder(" " + i);
            }
            else{
                row = new StringBuilder(i);
            }
            for ( int j = 0; j < ocean.length; j++){
                if(isHidden && ocean[i][j].graphic().equals("⚓️")){
                    row.append("\uD83C\uDF0A");
                }
                else{
                    row.append(ocean[i][j].graphic());
                }
            }
            System.out.println(row);
        }
    }

    public void provideName(){
        System.out.println("Enter your nick name:");
    }

    public void printWinner(String player){
        System.out.println(player + " won!");
    }

    public void providePlacementCoo(ShipType shipType){
        System.out.println("Please provide a coordinate for "+shipType+". The length of this ship is: "+shipType.getLength());
    }
    public void provideDir(){
        System.out.println("Please select the direction of the placed ship! (N,S,E,W)");
    }

    public void provideShootCoo(){
        System.out.println("Please provide a coordinate to shoot!");
    }

    public void displayPlayerRound(String name){
        System.out.println("Your turn to fire " + name + "!");
    }

    public void displayShotSquare(){
        System.out.println("That square has been targeted before! Pick a different target!");
    }
}
