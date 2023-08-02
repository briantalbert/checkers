package checkers;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    private String color;
    private boolean isKing;
    public int row;
    public int col;
    
    public Piece(String newColor, int row, int col) {
        this.color = newColor;
        this.isKing = false;
        this.row = row;
        this.col = col;
    }

    public String getColor() {
        return color;
    }
    
    public int getRow() {
    	return row;
    }
    
    public int getCol() {
    	return col;
    }

    public boolean isKing() {
        return isKing;
    }

    public void setKing(boolean king) {
        isKing = king;
    }
    
    public List<Move> getValidMoves(Board board, Player currentPlayer) {
    	List<Move> validMoves = new ArrayList<>();
    	int x1 = row;
    	int y1 = col;
    	//System.out.println("Testing valid moves for " + x1 + ", " + y1);
    	for (int i = 0; i < 8; i++) {
        	for (int j = 0; j < 8; j++) {
        		int x2 = i;
        		int y2 = j;
        		Move testMove = new Move(x1, y1, x2, y2);
        		if (testMove.isValidMove(board, currentPlayer)) {
        			//System.out.println(testMove.toString() + " is valid.");
        			validMoves.add(testMove);
        		}
        	}
        }
    	
    	return validMoves;
    	
    }
}
