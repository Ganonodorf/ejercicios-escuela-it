package Chess;

public class Move {
	Piece piece;
	
	Coordinate destiny;
	
	boolean isCapture;
	
	public Move(String move, Color color) {
		Coordinate origin = new Coordinate(move.charAt(1), Character.getNumericValue(move.charAt(2)) - 1);
		
		destiny = new Coordinate(move.charAt(move.length() - 2), Character.getNumericValue(move.charAt(move.length() - 1)) - 1);
		
		piece = PieceToMove(move.charAt(0), origin, color);
		
		isCapture = move.contains("x") ? true : false;
	}
	
	private Piece PieceToMove(char code, Coordinate origin, Color color) {
		Piece piece;
		
		switch(code) {
		case 'k':
			piece = new King(origin, color);
			break;
		case 'q':
			piece = new Queen(origin, color);
			break;
		case 'r':
			piece = new Rook(origin, color);
			break;
		case 'n':
			piece = new Knight(origin, color);
			break;
		case 'b':
			piece = new Bishop(origin, color);
			break;
		case 'p':
			piece = new Pawn(origin, color);
			break;
		default:
			piece = new King(origin, color);
			break;
		}
		
		return piece;
	}
	
	public static void main(String[] args) {
		Move move = new Move("pc2c3", Color.WHITE);
		
		System.out.println(move.piece.coordinate.getX());
		System.out.println(move.piece.coordinate.getY());
		
		System.out.println(move.destiny.getX());
		System.out.println(move.destiny.getY());
		
		Move move2 = new Move("ph8a1", Color.WHITE);
		
		System.out.println(move2.piece.coordinate.getX());
		System.out.println(move2.piece.coordinate.getY());
		
		System.out.println(move2.destiny.getX());
		System.out.println(move2.destiny.getY());
	}
}
