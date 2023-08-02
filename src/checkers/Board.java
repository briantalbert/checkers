package checkers;

import java.util.ArrayList;

public class Board {
    private static final int BOARD_SIZE = 8;
    private Piece[][] pieces;

    public Board(Player player1, Player player2) {
        pieces = new Piece[BOARD_SIZE][BOARD_SIZE];
        initializeBoard(player1, player2);
    }

    //Initialize pieces for both players, place them on the board.
    private void initializeBoard(Player player1, Player player2) {
        // Initialize Red pieces
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if ((row + col) % 2 != 0) { // Place pieces on alternate cells for a checkerboard pattern
                    Piece redPiece = new Piece("red", row, col);
                    pieces[row][col] = redPiece;
                    player1.addPiece(redPiece);
                }
            }
        }

        // Initialize Black pieces
        for (int row = 5; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if ((row + col) % 2 != 0) { // Place pieces on alternate cells for a checkerboard pattern
                    Piece blackPiece = new Piece("black", row, col);
                    pieces[row][col] = blackPiece;
                    player2.addPiece(blackPiece);
                }
            }
        }
    }

    //Return true if the position is on a standard checkerboard.
    public boolean isPositionValid(int x, int y) {
        if (x >= 0 && x < BOARD_SIZE && y >= 0 && y < BOARD_SIZE) {
        	return true;
        } else {
        	return false;
        }
    }
    
    // Return the piece object if it exists at the specified position, otherwise return null.
    public Piece getPieceAtPosition(int x, int y) {
    	if (pieces[x][y] == null) {
    		return null;
    	}
    	
    	return pieces[x][y];
    }
    
    //Set a piece on a given square. Confirm validity of move first.
    public void setPieceAtPosition(int x, int y, Piece piece) {
        pieces[x][y] = piece;
    }
    
    //Remove a piece from a given square.
    public void removePieceAtPosition(int x, int y) {
        if (pieces[x][y] != null) {
        	pieces[x][y] = null;
        }
    }
    
    // Return true if the cell is empty (no piece), otherwise false.
    public boolean isCellEmpty(int x, int y) {
        if (pieces[x][y] == null) {
        	return true;
        }
        
        return false;
        
    }

    //Return true if specified cell has an opponent's piece on it
    public boolean isCellOccupiedByOpponent(int x, int y, Player currentPlayer) {
        if (pieces[x][y] == null) {
        	return false;
        } else if (pieces[x][y].getColor() == currentPlayer.getColor()) {
        	return false;
        }
        
        return true;
    }
    
    //Return true if specified cell is occupied by a king.
    public boolean isCellOccupiedByKing(int x, int y) {
        if (pieces[x][y].isKing()) {
        	return true;
        }
        
        return false;
    }
    
    //Check if piece can be promoted to king. If a red piece gets to the last row, it is 
    //valid for promotion. If a black piece gets to the top row, it is valid for 
    //promotion.
    public boolean isCellValidForPromotion(int x, String color) {
        if (color == "red" && x == 7) {
        	return true;
        } else if (color == "black" && x == 0) {
        	return true;
        }
        
        return false;
    }
    
    //Set piece as king
    public void promoteToKing(int x, int y) {
        pieces[x][y].setKing(true);
    }
    
    //Get list of lists of cells with a specified color piece
    public ArrayList<ArrayList<Integer>> getOccupiedCells(String color) {
    	ArrayList<ArrayList<Integer>> piecesList = new ArrayList<>();
    	ArrayList<Integer> cell = new ArrayList<Integer>();
    	
    	for (int row = 0; row < BOARD_SIZE; row++) {
    		for (int col = 0; col < BOARD_SIZE; col++) {
    			if (pieces[row][col] != null && pieces[row][col].getColor() == color) {
    				cell.add(row);
    				cell.add(col);
    				piecesList.add(cell);
    			}
    		}
    	}
    	return piecesList;
    }
    
    //Print the board to console.
    public void printBoard() {
        System.out.println("    0  1  2  3  4  5  6  7");
        System.out.println("  +------------------------");
        for (int row = 0; row < BOARD_SIZE; row++) {
        	System.out.print(row + " | ");
        	for (int col = 0; col < BOARD_SIZE; col++) {
        		Piece piece = pieces[row][col];
        		if (piece != null) {
        			if (piece.getColor() == "red") {
        				if (piece.isKing()) {
        					System.out.print("RK ");
        				} else {
        					System.out.print("R  ");
        				}
        			} else if (piece.getColor() == "black") {
        				if (piece.isKing()) {
        					System.out.print("BK ");
        				} else {
        					System.out.print("B  ");
        				}
        			}
        		} else {
        			System.out.print(".  ");
        		}
        	}
        	System.out.println();
        }
    }
}
