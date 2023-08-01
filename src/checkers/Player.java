package checkers;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String color;
    private List<Piece> pieces;

    public Player(String color) {
        this.color = color;
        pieces = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Piece piece = new Piece(color);
            pieces.add(piece);
        }
    }

    public String getColor() {
        return color;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void addPiece(Piece piece) {
        pieces.add(piece);
    }

    public void removePiece(Piece piece) {
        pieces.remove(piece);
    }

    public boolean hasPiecesLeft() {
        return !pieces.isEmpty();
    }

    public boolean hasWon() {
        // Implement the logic to check if the player has won the game
        // For example, the opponent has no pieces left, or the opponent's pieces are blocked.
        // Return true if the player has won, otherwise false.
    }

    public Move getMove() {
        // Implement the logic to get the player's move from user input or an AI algorithm
        // Return the move object representing the player's selected move.
    }
}

