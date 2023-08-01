package checkers;

import java.awt.Color;

public class Piece {
    private Color color;
    private boolean isKing;

    public Piece(Color color) {
        this.color = color;
        this.isKing = false;
    }

    public Color getColor() {
        return color;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean king) {
        isKing = king;
    }
}
