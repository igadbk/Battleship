package com.codecool.battleship.square;

public enum SquareStatus {
    EMPTY("\uD83C\uDF0A"),
    SHIP("⚓️"),
    HIT("\uD83D\uDD25"),
    SUNK("☠️"),
    MISSED("\uD83E\uDD88");

    private final String graphic;

    SquareStatus(String graphic) {
        this.graphic = graphic;
    }

    public String getGraphic() {
        return graphic;
    }
}
