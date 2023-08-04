package checkers;

import javax.swing.*;
import java.awt.*;

public class CheckersGUI extends JFrame {
	
	private static final int BOARD_SIZE = 8;
	private static final int CELL_SIZE = 60;

	private JPanel boardPanel;
	
	public CheckersGUI(Board board) {
		initializeBoard(board);
		
		setTitle("Checkers");
		setSize(BOARD_SIZE * CELL_SIZE, BOARD_SIZE * CELL_SIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		boardPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
		boardPanel.setBorder(BorderFactory.createMatteBorder(30, 30, 30, 90, Color.WHITE));
		
		add(boardPanel);
		setVisible(true);
	}
	
	private void initializeBoard(Board board) {
		boardPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
		
		//Create cells for each square
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				JPanel cell = new JPanel();
				cell.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
				cell.setBackground((row + col) % 2 == 0 ? Color.LIGHT_GRAY : Color.DARK_GRAY);
				
				Piece piece = board.getPieceAtPosition(row, col);
                if (piece != null) {
                	cell.setLayout(new GridBagLayout());
                    Circle circlePiece = new Circle(25, piece.getColor());
                    cell.add(circlePiece);
                }
				
				boardPanel.add(cell);
		
			}
		}
	}

}
