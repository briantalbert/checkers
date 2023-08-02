package checkers;

public class Game {
    public Board board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    private boolean isGameOver;
    
    public static void main(String[] args) {
    	Game game = new Game();
    	game.start();
    }
    public Game() {
        player1 = new Player("red"); // Assuming Red starts the game
        player2 = new Player("black");
        board = new Board(player1, player2);
        currentPlayer = player1;
        isGameOver = false;
    }

    public void start() {
        while (!isGameOver) {
        	System.out.print("\033[H\033[2J");
            System.out.flush();
            displayBoard();
            Move move = new Move(0,0,0,0); //Invalid move to trigger while loop
            
            while (!move.isValidMove(board, currentPlayer)) {
            	move = currentPlayer.getMove(board, currentPlayer); 
            }
            
            makeMove(move);
            if (currentPlayer.hasWon()) {
                displayWinner();
                isGameOver = true;
            } else {
                currentPlayer = (currentPlayer == player1) ? player2 : player1; // Switch turns
            }
        
        }
    }

    
    private void makeMove(Move move) {
    	int x1 = move.getStartX();
    	int x2 = move.getEndX();
    	
    	int y1 = move.getStartY();
    	int y2 = move.getEndY();
    	
    	//Remove the piece from start, place it at the end
    	Piece pieceToMove = board.getPieceAtPosition(x1, y1);
    	board.removePieceAtPosition(x1, y1);
    	board.setPieceAtPosition(x2, y2, pieceToMove);
    	pieceToMove.setPosition(x2, y2);
    	
    	//Capture, if a capture move
    	if (move.isCaptureMove()) {
    		int midX = (x1 + x2) / 2;
            int midY = (y1 + y2) / 2;
            
            Piece capturedPiece = board.getPieceAtPosition(midX, midY);
            Player otherPlayer = (currentPlayer == player1) ? player2 : player1;
            otherPlayer.removePiece(capturedPiece);
            board.removePieceAtPosition(midX, midY);
            currentPlayer.capturePiece(capturedPiece);    
    	}
    	
    	//Can the piece be king'd?
    	if (currentPlayer.getColor() == "red" && x2 == 7 && !pieceToMove.isKing()) {
    		pieceToMove.setKing(true);	
    	} else if (currentPlayer.getColor() == "black" && x2 == 0 && !pieceToMove.isKing()) {
    		pieceToMove.setKing(true);	
    	}
    	
    }

    private void displayBoard() {
        board.printBoard();
    }

    private void displayWinner() {
        System.out.println("Game over! The " + currentPlayer.getColor() + " player wins!");
    }

}
