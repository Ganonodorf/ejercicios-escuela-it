package Chess;

public class Movement {
	Piece piece;
	
	Coordinate destiny;
	
	boolean isCapture;
	
	public Movement(String movement, Color color) {
		Coordinate origin = new Coordinate(movement.charAt(1), Character.getNumericValue(movement.charAt(2)) - 1);
		
		destiny = new Coordinate(movement.charAt(movement.length() - 2), Character.getNumericValue(movement.charAt(movement.length() - 1)) - 1);
		
		piece = parsePiece(movement.charAt(0), origin, color);
		
		isCapture = movement.contains("x") ? true : false;
	}
	
	private Piece parsePiece(char code, Coordinate origin, Color color) {
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
		Movement movement = new Movement("pc2c3", Color.WHITE);
		
		System.out.print(movement.piece.coordinate.getX());
		System.out.println(movement.piece.coordinate.getY());
		
		System.out.print(movement.destiny.getX());
		System.out.println(movement.destiny.getY());
		
		Movement movement2 = new Movement("ph8a1", Color.WHITE);
		
		System.out.print(movement2.piece.coordinate.getX());
		System.out.println(movement2.piece.coordinate.getY());
		
		System.out.print(movement2.destiny.getX());
		System.out.println(movement2.destiny.getY());
	}
}
