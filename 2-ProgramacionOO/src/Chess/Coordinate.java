package Chess;

public class Coordinate {
	
	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean isInSameRow(Coordinate coordinate) {
		return this.y == coordinate.y;
	}
	
	public boolean isInSameColumn(Coordinate coordinate) {
		return this.x == coordinate.x;
	}
	
	public boolean isInPrimaryDiagonal(Coordinate coordinate) {
		return this.x - coordinate.x == this.y - coordinate.y;
	}
	
	public boolean isInSecondaryDiagonal(Coordinate coordinate) {
		return this.x - coordinate.x == coordinate.y - this.y;
	}
	
	public int distance(Coordinate coordinate) {
		if(isInSameColumn(coordinate)) {
			return Math.abs(this.y - coordinate.y);
		}
		
		if(isInSameRow(coordinate) || isInPrimaryDiagonal(coordinate) || isInSecondaryDiagonal(coordinate)) {
			return Math.abs(this.x - coordinate.x);
		}
		
		return Math.abs(this.x - coordinate.x) + Math.abs(this.y - coordinate.y);
	}
}
