package checkers;

public class Piece {
    private String color;
    private boolean isKing;

    public Piece(String newColor) {
        this.color = newColor;
        this.isKing = false;
    }

    public String getColor() {
        return color;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean king) {
        isKing = king;
    }
}
