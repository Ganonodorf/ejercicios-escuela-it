package Chess;

public class King extends Piece{
	
	public King(Coordinate coordinate, Color color) {
		super(coordinate, color);
		
		this.shape = color == Color.WHITE ? '♔' : '♚';
	}

	@Override
	public boolean canMove(Coordinate coordinate) {
		return this.coordinate.distance(coordinate) == 1;
	}
}
