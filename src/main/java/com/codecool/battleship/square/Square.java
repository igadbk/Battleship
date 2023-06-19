package com.codecool.battleship.square;

public class Square {
    private final int X;
    private final int Y;
    private SquareStatus squareStatus;

    public Square(int x, int y) {
        X = x;
        Y = y;
        squareStatus = SquareStatus.EMPTY;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }

    public void setSquareStatus(SquareStatus squareStatus) {
        this.squareStatus = squareStatus;
    }

    public String graphic(){
        return squareStatus.getGraphic();
    }
}
