package checkers;

import java.awt.Color;

public class Game {
    private Board board;
    private Player currentPlayer;
    private Player player1;
    private Player player2;
    private boolean isGameOver;

    public Game() {
        board = new Board();
        player1 = new Player(Color.RED); // Assuming Red starts the game
        player2 = new Player(Color.BLACK);
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
        // Implement the logic to check if the move is valid on the current board
        // This should consider the rules of the Checkers game (e.g., capturing, kinging, etc.)
        // Return true if the move is valid, otherwise false.
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
