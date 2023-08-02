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
            	move = currentPlayer.getMove(board, currentPlayer); // Implement this method to get player's move
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
    	System.out.println(x1 + x2 + y1 + y2);
        // Implement the logic to update the board based on the move
        // This should update the positions of pieces, handle captures, and promote kings.
    }

    private void displayBoard() {
        board.printBoard();
    }

    private void displayWinner() {
        // Implement the logic to display the winner of the game
    }

}
