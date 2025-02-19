package Chess;

public abstract class Piece {
	
	private Coordinate coordinate;
	
	private Color color;
	
	public Piece(Coordinate coordinate, Color color) {
		this.coordinate = coordinate;
		this.color = color;
	}

	public abstract boolean canMove(Coordinate coordinate);
	
	public abstract boolean canCapture(Coordinate coordinate);
	
	public abstract void move(Coordinate coordinate);
	
	public boolean isInCoordinate(Coordinate coordinate) {
		return this.coordinate.isInSameCoordinate(coordinate);
	}
	
	public boolean shareColor(Piece piece) {
		return this.color == piece.color;
	}
}
