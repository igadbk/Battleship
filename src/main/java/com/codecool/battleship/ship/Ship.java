package com.codecool.battleship.ship;

import com.codecool.battleship.square.Square;
import com.codecool.battleship.player.Player;
import com.codecool.battleship.square.SquareStatus;

import java.util.List;


public class Ship {
    private List<Square> position;
    private ShipType shipType;
    private Player player;
    private boolean isSunk;

    public Ship(List<Square> position, ShipType shipType, Player player) {
        this.position = position;
        this.shipType = shipType;
        this.player = player;
        this.isSunk = false;
    }


    public Player getPlayer() {
        return player;
    }


    public boolean getSunk() {
        return isSunk;
    }

    public void setSunk(boolean sunk) {
        isSunk = sunk;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public List<Square> getPosition() {
        return position;
    }

    public boolean isSunk() {
        for (Square square : this.position) {
            if (square.getSquareStatus() == SquareStatus.SHIP) {
                return false;
            }
        }
        return true;
    }

}
