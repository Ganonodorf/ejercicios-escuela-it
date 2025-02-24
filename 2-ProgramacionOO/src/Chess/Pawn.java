package Chess;

public class Pawn extends Piece{

	public Pawn(Coordinate coordinate, Color color) {
		super(coordinate, color);
		
		this.shape = color == Color.WHITE ? '♙' : '♟';
	}

	@Override
	public boolean canMove(Coordinate coordinate) {
		int movement = color == Color.WHITE ? 1 : -1;
		
		Coordinate possibleMovement = this.coordinate.clone();
		possibleMovement.displace(0, movement);

		return possibleMovement.isInSameCoordinate(coordinate);
	}

	@Override
	public boolean canCapture(Coordinate coordinate) {
		int movement = color == Color.WHITE ? 1 : -1;
		
		Coordinate possibleMovement = this.coordinate.clone();
		possibleMovement.displace(1, movement);
		Coordinate possibleMovement2 = this.coordinate.clone();
		possibleMovement2.displace(-1, movement);
		
		return possibleMovement.isInSameCoordinate(coordinate) ||
				possibleMovement2.isInSameCoordinate(coordinate);
	}
	
	public static void main(String[] args) {
		Pawn pawn = new Pawn(new Coordinate(2, 2), Color.WHITE);
		
		System.out.println(pawn.canMove(new Coordinate(2, 3)));
		
		pawn = new Pawn(new Coordinate(2, 2), Color.WHITE);
		
		System.out.println(pawn.canCapture(new Coordinate(3, 3)));
		
		pawn = new Pawn(new Coordinate(2, 2), Color.WHITE);
		
		System.out.println(pawn.canCapture(new Coordinate(1, 3)));
		
		pawn = new Pawn(new Coordinate(2, 2), Color.WHITE);
		
		System.out.println(pawn.canCapture(new Coordinate(2, 3)));
	}
}
