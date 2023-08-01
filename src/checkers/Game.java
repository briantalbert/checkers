package checkers;

public class Game {

	public static void main(String[] args) {
		System.out.println("Game Started");
		
		Piece testPiece = new Piece(0, 0, "black");
		System.out.println(testPiece.getValidMoves());
	}

}
