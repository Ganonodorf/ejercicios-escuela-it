package Chess;

public abstract class Piece {
	
	protected Coordinate coordinate;
	
	protected Color color;
	
	protected char shape;
	
	protected char type;
	
	public Piece(Coordinate coordinate, Color color) {
		this.coordinate = coordinate;
		this.color = color;
	}

	public abstract boolean canMove(Coordinate coordinate);
	
	public boolean canCapture(Coordinate coordinate) {
		return this.canMove(coordinate);
	}
	
	public void move(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public boolean isInCoordinate(Coordinate coordinate) {
		return this.coordinate.isInSameCoordinate(coordinate);
	}
	
	public boolean shareColor(Piece piece) {
		return this.color == piece.color;
	}
	
	public boolean shareType(Piece piece) {
		return this.type == piece.type;
	}
	
	public void Show() {
		System.out.print(shape);
	}
}
