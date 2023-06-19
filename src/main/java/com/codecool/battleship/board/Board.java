package com.codecool.battleship.board;

import com.codecool.battleship.display.Display;
import com.codecool.battleship.square.Square;
public class Board {
    private Square[][] ocean;
    private boolean isHidden = false;
    private Display display = new Display();

    public Square[][] getOcean() {
        return ocean;
    }

    public void setOcean(Square[][] ocean) {
        this.ocean = ocean;
    }

    public Board(int boardSize){
        ocean = new Square[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                ocean[i][j] = new Square(i, j);
            }
        }
    }

    public void isPlacementOk(){

    }

    public boolean isIsHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean ishidden) {
        this.isHidden = ishidden;
    }

    public void display(){
        display.displayBoard(ocean, isHidden);
    }
}
