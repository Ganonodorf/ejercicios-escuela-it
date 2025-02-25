package Chess;

public class Bishop extends Piece{

	public Bishop(Coordinate coordinate, Color color) {
		super(coordinate, color);
		
		this.shape = color == Color.WHITE ? '♗' : '♝';
		
		this.type = 'b';
	}

	@Override
	public boolean canMove(Coordinate coordinate) {
		return this.coordinate.isInPrimaryDiagonal(coordinate) ||
				this.coordinate.isInSecondaryDiagonal(coordinate);
	}
	
	public static void main(String[] args) {
		Bishop bishop = new Bishop(new Coordinate(4, 4), Color.WHITE);
		
		Coordinate destiny = new Coordinate(6, 6);
		
		System.out.println(bishop.canMove(destiny));
		
		destiny = new Coordinate(2, 6);
		
		System.out.println(bishop.canMove(destiny));
		
		destiny = new Coordinate(4, 4);
		
		System.out.println(bishop.canMove(destiny));
		
		destiny = new Coordinate(6, 2);
		
		System.out.println(bishop.canMove(destiny));
	}
}
