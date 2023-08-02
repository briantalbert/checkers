package checkers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String color;
    private List<Piece> pieces = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public Player(String color) {
        this.color = color;
        //pieces = new ArrayList<>();
        //for (int i = 0; i < 12; i++) {
        //    Piece piece = new Piece(color);
        //    pieces.add(piece);
        //}
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
    //add basic AI for a computer player later.
    public Move getMove(Board board, Player player) {
    	List<Move> validMoves = new ArrayList<>();
    	List<Piece> movablePieces = new ArrayList<>();
    	
		Scanner input = new Scanner(System.in);
    	int ctr = 1;
    	
        for (Piece piece : pieces) {
        	if (piece.getValidMoves(board, player).size() > 0) {
        		
        		movablePieces.add(piece);
	        	System.out.println(ctr + ". (" + piece.getRow() + ", " + piece.getCol() + ")");
	        	++ctr;
        	}
        }
        ctr = 1;
        System.out.print("Enter the number for the piece you wish to move >");
        int idx = input.nextInt();
        Piece chosenPiece = movablePieces.get(idx - 1);
        int x1 = chosenPiece.getRow();
        int y1 = chosenPiece.getCol();
        for (int i = 0; i < 8; i++) {
        	for (int j = 0; j < 8; j++) {
        		int x2 = i;
        		int y2 = j;
        		Move testMove = new Move(x1, y1, x2, y2);
        		if (testMove.isValidMove(board, player)) {
        			validMoves.add(testMove);
        		}
        	}
        }
        
        for (Move move : validMoves) {
        	System.out.println(ctr + ". " + move.toString());
        	++ctr;
        }
        
        System.out.print("Enter the number for the move you wish to make >");
        idx = input.nextInt();
        Move chosenMove = validMoves.get(idx - 1);
        
    	return chosenMove;
    }
}

//System.out.println("Enter starting square in the form \"row, column\".");
//System.out.print("For example - 5,3:");
