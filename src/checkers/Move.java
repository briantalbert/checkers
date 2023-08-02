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
    
    public boolean isValidMove(Board board, Player currentPlayer) {
    	int x1 = this.getStartX();
    	int x2 = this.getEndX();
    	
    	int y1 = this.getStartY();
    	int y2 = this.getEndY();
    	
    	//Are both the start and end squares valid?
        if (!board.isPositionValid(x1, y1)) {
        	return false;
        } else if (!board.isPositionValid(x2, y2)) {
        	return false;
        }
        
//        System.out.println(this.toString());
//        System.out.println("Both start and end squares valid.");
        
        //Is there a piece on the start square?
        //Does it belong to the current player?
        Piece piece = board.getPieceAtPosition(x1, y1);
        if (piece == null || piece.getColor() != currentPlayer.getColor()) {
            return false;
        }
//        System.out.println(this.toString());
//        System.out.println("The piece on the start square is " + piece.getColor() + " and belongs to the " + currentPlayer.getColor() + " player.");
//        
        
        //Is the end square empty?
        if (!board.isCellEmpty(x2, y2)) {
            return false;
        }
//        System.out.println(this.toString());
//        System.out.println("End square is empty.");
//        
        //Is the move the same number of spaces X and Y?
        if (Math.abs(x2 - x1) != Math.abs(y2 - y1)) {
        	return false;
        }
//        System.out.println(this.toString());
//        System.out.println("Same #spaces x and y");
//        
        if (Math.abs(x2 - x1) > 2) {
        	return false;
        }
        
//        System.out.println(this.toString());
//        System.out.println("Not moving too far");
//        
        
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
//        System.out.println(this.toString());
//        System.out.println("If it's a capture attempt, it's valid.");
//        
        return true;   
    }
    
    public boolean isCaptureMove() {
    	if (Math.abs(this.endX) - Math.abs(this.startX) == 2) {
        	return true;
        }
    	return false;
    }

    @Override
    public String toString() {
        return "Move: (" + startX + ", " + startY + ") -> (" + endX + ", " + endY + ")";
    }
}
 
