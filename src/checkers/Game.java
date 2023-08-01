package checkers;

import java.awt.Color;

public class Game {
    private Board board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    private boolean isGameOver;

    public Game() {
        player1 = new Player(Color.RED); // Assuming Red starts the game
        player2 = new Player(Color.BLACK);
        board = new Board(player1, player2);
        currentPlayer = player1;
        isGameOver = false;
    }

    public void start() {
        while (!isGameOver) {
            displayBoard();
            Move move = currentPlayer.getMove(); // Implement this method to get player's move
            if (isValidMove(move)) {
                makeMove(move);
                if (currentPlayer.hasWon()) {
                    displayWinner();
                    isGameOver = true;
                } else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1; // Switch turns
                }
            } else {
                displayInvalidMoveMessage();
            }
        }
    }

    private boolean isValidMove(Move move) {
    	int x1 = move.getStartX();
    	int x2 = move.getEndX();
    	
    	int y1 = move.getStartY();
    	int y2 = move.getEndY();
    	
    	//Are both the start and end squares valid?
        if (!board.isPositionValid(x1, y1)) {
        	return false;
        } else if (!board.isPositionValid(x2, y2)) {
        	return false;
        }
        
        //Is there a piece on the start square?
        //Does it belong to the current player?
        Piece piece = board.getPieceAtPosition(x1, y1);
        if (piece == null || piece.getColor() != currentPlayer.getColor()) {
            return false;
        }
        
        //Is the end square empty?
        if (!board.isCellEmpty(x2, y2)) {
            return false;
        }
        
        //Is the move the same number of spaces X and Y?
        if (Math.abs(x2 - x1) != Math.abs(y2 - y1)) {
        	return false;
        }
        
        //If they moved 2 squares, is it a valid capture?
        if (x2 - x1 == 2) {
        	//Moved southeast
        	if (y2 - y1 == 2) {
        		piece = board.getPieceAtPosition(x1 + 1, y1 + 1);
        		 if (piece == null || piece.getColor() == currentPlayer.getColor()) {
        	            return false;
        	        }
            //moved southwest
        	} else if (y2 - y1 == -2) {
        		piece = board.getPieceAtPosition(x1 + 1, y1 - 1);
       		 if (piece == null || piece.getColor() == currentPlayer.getColor()) {
       	            return false;
       	        }
        	}        	
        }
        
        if (x2 - x1 == -2) {
        	//Moved northeast
        	if (y2 - y1 == 2) {
        		piece = board.getPieceAtPosition(x1 - 1, y1 + 1);
        		 if (piece == null || piece.getColor() == currentPlayer.getColor()) {
        	            return false;
        	        }
            //moved northwest
        	} else if (y2 - y1 == -2) {
        		piece = board.getPieceAtPosition(x1 - 1, y1 - 1);
       		 if (piece == null || piece.getColor() == currentPlayer.getColor()) {
       	            return false;
       	        }
        	}        	
        }
        
        return true;
        
    }

    private void makeMove(Move move) {
        // Implement the logic to update the board based on the move
        // This should update the positions of pieces, handle captures, and promote kings.
    }

    private void displayBoard() {
        // Implement the logic to display the current state of the board
    }

    private void displayWinner() {
        // Implement the logic to display the winner of the game
    }

    private void displayInvalidMoveMessage() {
        // Implement the logic to display a message when an invalid move is attempted
    }
}
