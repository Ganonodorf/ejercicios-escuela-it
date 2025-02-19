package Chess;

public abstract class Piece {
	
	private Coordinate coordinate;
	
	public Piece(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public abstract boolean canMove(Coordinate coordinate);
	
	public abstract boolean canCapture(Coordinate coordinate);
	
	public abstract void move(Coordinate coordinate);
}
