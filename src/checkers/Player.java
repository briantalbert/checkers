package checkers;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String color;
    private List<Piece> pieces;
    private List<Piece> capturedPieces;

    public Player(String color) {
        this.color = color;
        pieces = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Piece piece = new Piece(color);
            pieces.add(piece);
        }
    }
    
    //Get this player's color
    public String getColor() {
        return color;
    }
    
    //Get list of remaining pieces
    public List<Piece> getPieces() {
        return pieces;
    }
    
    //Add piece to this player's list. Should only
    //be used at initialization.
    public void addPiece(Piece piece) {
        pieces.add(piece);
    }
    
    //Remove piece (if captured)
    public void removePiece(Piece piece) {
        pieces.remove(piece);
    }
    
    //Capture opponent's piece
    public void capturePiece(Piece piece) {
    	capturedPieces.add(piece);
    }
    
    //Self-explanatory
    public boolean hasPiecesLeft() {
        return !pieces.isEmpty();
    }
    
    //Return true if the player has won (has pieces left, and 
    //has captured all opponent's pieces), otherwise false.
    public boolean hasWon() {
        return (this.hasPiecesLeft() && this.capturedPieces.size() == 12);
    }
    
    //Get move from player. Right now, manually entered. Hope to 
    //add AI for a computer player later.
    public Move getMove() {
        // Implement the logic to get the player's move from user input or an AI algorithm
        // Return the move object representing the player's selected move.
    }
}

