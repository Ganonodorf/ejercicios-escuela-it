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
			number = 1;
			break;
		case 'b':
			number = 2;
			break;
		case 'c':
			number = 3;
			break;
		case 'd':
			number = 4;
			break;
		case 'e':
			number = 5;
			break;
		case 'f':
			number = 6;
			break;
		case 'g':
			number = 7;
			break;
		case 'h':
			number = 8;
			break;
		default:
			number = 1;
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
	
	public void move(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
