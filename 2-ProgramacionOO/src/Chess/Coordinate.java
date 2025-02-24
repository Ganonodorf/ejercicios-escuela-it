package Chess;

public class Coordinate {
	
	private int x;
	private int y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Coordinate(char letter, int y) {
		this.x = letterToNumber(letter);
		this.y = y;
	}
	
	private int letterToNumber(char letter) {
		int number;
		
		switch(letter) {
		case 'a':
			number = 0;
			break;
		case 'b':
			number = 1;
			break;
		case 'c':
			number = 2;
			break;
		case 'd':
			number = 3;
			break;
		case 'e':
			number = 4;
			break;
		case 'f':
			number = 5;
			break;
		case 'g':
			number = 6;
			break;
		case 'h':
			number = 7;
			break;
		default:
			number = 0;
			break;
		}
		
		return number;
	}
	
	public boolean isInSameCoordinate(Coordinate coordinate) {
		return this.x == coordinate.x && this.y == coordinate.y;
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
	
	public Coordinate clone() {
		return new Coordinate(this.x, this.y);
	}
	
	public void displace(int xMovement, int yMovement) {
		this.x += xMovement;
		this.y += yMovement;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
