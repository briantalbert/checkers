package checkers;

public class Move {
    private int startX; // Starting X position of the piece
    private int startY; // Starting Y position of the piece
    private int endX;   // Ending X position of the piece
    private int endY;   // Ending Y position of the piece

    public Move(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    // Getters and setters for the fields (if needed)

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getEndX() {
        return endX;
    }

    public void setEndX(int endX) {
        this.endX = endX;
    }

    public int getEndY() {
        return endY;
    }

    public void setEndY(int endY) {
        this.endY = endY;
    }

    @Override
    public String toString() {
        return "Move: (" + startX + ", " + startY + ") -> (" + endX + ", " + endY + ")";
    }
}

