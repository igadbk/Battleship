package com.codecool.battleship.ship;

public enum ShipType {
    CARRIER(5),
    CRUISER(4),
    BATTLESHIP(3),
    SUBMARINE(2),
    DESTROYER(1);

    private final int length;

    ShipType(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
