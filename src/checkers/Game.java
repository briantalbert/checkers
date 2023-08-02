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

    //TODO
    private void makeMove(Move move) {
    	int x1 = move.getStartX();
    	int x2 = move.getEndX();
    	
    	int y1 = move.getStartY();
    	int y2 = move.getEndY();

    	Piece pieceToMove = board.getPieceAtPosition(x1, y1);
    	board.removePieceAtPosition(x1, y1);
    	board.setPieceAtPosition(x2, y2, pieceToMove);
    	
    	if (move.isCaptureMove()) {
    		int midX = (x1 + x2) / 2;
            int midY = (y1 + y2) / 2;
            
            Piece capturedPiece = board.getPieceAtPosition(midX, midY);
            board.removePieceAtPosition(midX, midY);
            currentPlayer.capturePiece(capturedPiece);
            
    	}
    	// Implement the logic to update the board based on the move
        // This should update the positions of pieces, handle captures, and promote kings.
    }

    private void displayBoard() {
        board.printBoard();
    }

    private void displayWinner() {
        System.out.println("Game over! The " + currentPlayer.getColor() + " player wins!");
    }

}
