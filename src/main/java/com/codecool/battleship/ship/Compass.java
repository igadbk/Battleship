package com.codecool.battleship.ship;

public enum Compass {
    NORTH(-1,0),
    SOUTH(1,0),
    EAST(0,1),
    WEST(0,-1);

    private final int x;
    private final int y;

    Compass(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int[] getCoo(){
        int[] coo = new int[2];
        coo[0] = this.x;
        coo[1] = this.y;
        return coo;
    }
}
