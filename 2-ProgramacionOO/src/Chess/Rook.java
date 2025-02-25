package Chess;

public class Rook extends Piece{

	public Rook(Coordinate coordinate, Color color) {
		super(coordinate, color);
		
		this.shape = color == Color.WHITE ? '♖' : '♜';
		
		this.type = 'r';
	}

	@Override
	public boolean canMove(Coordinate coordinate) {
		return this.coordinate.isInSameColumn(coordinate) ||
				this.coordinate.isInSameRow(coordinate);
	}
}
