package com.codecool.battleship.player;

import com.codecool.battleship.display.Display;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareStatus;
import com.codecool.battleship.board.Board;

import java.util.Arrays;
import java.util.List;

public class Player {
    private Display display = new Display();
    private List<Ship> ships;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void shoot(Player enemyPlayer, Square targetSquare) {
        for (Ship ship : enemyPlayer.ships) {
            for (Square pos : ship.getPosition()) {
                if (pos == targetSquare) {
                    pos.setSquareStatus(SquareStatus.HIT);
                    if (ship.isSunk()){
                        markSunk(ship);
                    }
                    break;
                }
            }
        }
        if (targetSquare.getSquareStatus() == SquareStatus.EMPTY) {
            targetSquare.setSquareStatus(SquareStatus.MISSED);
        }
    }

    private void markSunk(Ship ship){
        for (Square square:ship.getPosition()){
            square.setSquareStatus(SquareStatus.SUNK);
        }
        ship.setSunk(true);
    }

    public boolean isAlive() {
        for (Ship ship : ships) {
            if (!ship.getSunk()) {
                return true;
            }
        }
        return false;
    }

    public void UnbeatableAiShoot(Player enemyPlayer, Board board) {
        Square[][] table = board.getOcean();
        int x= 0;
        int y = 0;
        for (int i= 0; i<table.length; i++){
            for (int j= 0; j<table[i].length; j++){
                if(table[i][j].getSquareStatus() == SquareStatus.SHIP){
                    x = i;
                    y = j;
                }
            }
        }
        for (Ship ship : enemyPlayer.getShips()) {
            for (Square pos : ship.getPosition()) {
                if (pos.getX() == x && pos.getY() == y) {
                    pos.setSquareStatus(SquareStatus.HIT);
                    if (ship.isSunk()){
                        markSunk(ship);
                    }
                    break;
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public void displayRound(){
        display.displayPlayerRound(name);
    }
}
