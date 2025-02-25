package Chess;

public class Queen extends Piece{

	public Queen(Coordinate coordinate, Color color) {
		super(coordinate, color);
		
		this.shape = color == Color.WHITE ? '♕' : '♛';
		
		this.type = 'q';
	}

	@Override
	public boolean canMove(Coordinate coordinate) {
		return this.coordinate.isInPrimaryDiagonal(coordinate) ||
				this.coordinate.isInSecondaryDiagonal(coordinate) ||
				this.coordinate.isInSameColumn(coordinate) ||
				this.coordinate.isInSameRow(coordinate);
	}
}
