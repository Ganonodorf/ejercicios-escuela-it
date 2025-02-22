package Chess;

public class Bishop extends Piece{

	public Bishop(Coordinate coordinate, Color color) {
		super(coordinate, color);
		
		this.shape = color == Color.WHITE ? '♗' : '♝';
	}

	@Override
	public boolean canMove(Coordinate coordinate) {
		return this.coordinate.isInPrimaryDiagonal(coordinate) ||
				this.coordinate.isInSecondaryDiagonal(coordinate);
	}
}
