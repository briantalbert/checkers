package checkers;

public class Piece {
    private String color;
    private boolean isKing;

    public Piece(String color2) {
        this.color = color2;
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
