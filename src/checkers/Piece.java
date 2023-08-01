package checkers;

import java.util.ArrayList;
import java.util.List;

public class Piece {
	static int row;
	static int col;
	static String color;
	bool isKing;
	
	Piece(int newRow, int newCol, String newColor) {
		row = newRow;
		col = newCol;
		color = newColor;
	}
	
	public static int[] getLocation() {
		int[] coords = new int[2];
		coords[0] = row;
		coords[1] = col;
		
		return coords;
	}
	
	public static List<String> getValidMoves() {
        List<String> legalMoves = new ArrayList<>();

        // Checker can move diagonally to the left or right
        int[] dr = {-1, -1, 1, 1};
        int[] dc = {-1, 1, -1, 1};

        for (int i = 0; i < dr.length; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            // Check if the new position is within the board boundaries
            if (isValidPosition(newRow, newCol)) {
                legalMoves.add("(" + newRow + ", " + newCol + ")");
            }
        }

        return legalMoves;
    }

    public static boolean isValidPosition(int testRow, int testCol) {
        return testRow >= 0 && testRow < 8 && testCol >= 0 && testCol < 8;
    }
}
