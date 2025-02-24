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
	
	public Coordinate[] coordinatesTo(Coordinate coordinate) {
		Coordinate[] coordinatesBetween = null;
		
		if(isInSameColumn(coordinate)){
			int xDistanceTo = this.xDistanceTo(coordinate);
			
			if(xDistanceTo < 0) {
				coordinatesBetween = new Coordinate[-xDistanceTo];
				
				for(int i = 0; i < -xDistanceTo; i++) {
					coordinatesBetween[i] = new Coordinate(coordinate.x, coordinate.y + i);
				}
			}
			else {
				coordinatesBetween = new Coordinate[-xDistanceTo];
				
				for(int i = 0; i < xDistanceTo; i++) {
					coordinatesBetween[i] = new Coordinate(coordinate.x, coordinate.y - i);
				}
			}
		}
		else if(isInSameRow(coordinate)) {
			int yDistanceTo = this.yDistanceTo(coordinate);
			
			if(yDistanceTo < 0) {
				coordinatesBetween = new Coordinate[-yDistanceTo];
				
				for(int i = 0; i < -yDistanceTo; i++) {
					coordinatesBetween[i] = new Coordinate(coordinate.x + i, coordinate.y);
				}
			}
			else {
				coordinatesBetween = new Coordinate[-yDistanceTo];
				
				for(int i = 0; i < yDistanceTo; i++) {
					coordinatesBetween[i] = new Coordinate(coordinate.x - i, coordinate.y);
				}
			}
		}
		else if(this.isInPrimaryDiagonal(coordinate)) {
			int xDistanceTo = this.xDistanceTo(coordinate);
			
			if(xDistanceTo < 0) {
				coordinatesBetween = new Coordinate[-xDistanceTo];
				
				for(int i = 0; i < -xDistanceTo; i++) {
					coordinatesBetween[i] = new Coordinate(coordinate.x + i, coordinate.y + i);
				}
			}
			else {
				coordinatesBetween = new Coordinate[xDistanceTo];
				
				for(int i = 0; i < xDistanceTo; i++) {
					coordinatesBetween[i] = new Coordinate(coordinate.x - i, coordinate.y - i);
				}
			}
		}
		else if(this.isInSecondaryDiagonal(coordinate)) {
			int xDistanceTo = this.xDistanceTo(coordinate);
			
			if(xDistanceTo < 0) {
				coordinatesBetween = new Coordinate[-xDistanceTo];
				
				for(int i = 0; i < -xDistanceTo; i++) {
					coordinatesBetween[i] = new Coordinate(coordinate.x + i, coordinate.y - i);
				}
			}
			else {
				coordinatesBetween = new Coordinate[-xDistanceTo];
				
				for(int i = 0; i < xDistanceTo; i++) {
					coordinatesBetween[i] = new Coordinate(coordinate.x - i, coordinate.y + i);
				}
			}
		}
		
		return coordinatesBetween;
	}
	
	private int yDistanceTo(Coordinate coordinate) {
		return coordinate.y - this.y;
	}

	private int xDistanceTo(Coordinate coordinate) {
		return coordinate.x - this.x;
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
