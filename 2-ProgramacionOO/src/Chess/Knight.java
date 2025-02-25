package Chess;

public class Knight extends Piece{

	public Knight(Coordinate coordinate, Color color) {
		super(coordinate, color);
		
		this.shape = color == Color.WHITE ? '♘' : '♞';
		
		this.type = 'n';
	}

	@Override
	public boolean canMove(Coordinate coordinate) {
		Coordinate up1 = this.coordinate.clone();
		up1.displace(1, 2);
		Coordinate up2 = this.coordinate.clone();
		up2.displace(-1, 2);

		Coordinate right1 = this.coordinate.clone();
		right1.displace(2, 1);
		Coordinate right2 = this.coordinate.clone();
		right2.displace(2, -1);
		
		Coordinate down1 = this.coordinate.clone();
		up1.displace(1, -2);
		Coordinate down2 = this.coordinate.clone();
		up2.displace(-1, -2);

		Coordinate left1 = this.coordinate.clone();
		right1.displace(-2, 1);
		Coordinate left2 = this.coordinate.clone();
		right2.displace(-2, -1);
		
		return this.coordinate.isInSameCoordinate(up1) || 
				this.coordinate.isInSameCoordinate(up2) ||
				this.coordinate.isInSameCoordinate(right1) ||
				this.coordinate.isInSameCoordinate(right2) ||
				this.coordinate.isInSameCoordinate(left1) ||
				this.coordinate.isInSameCoordinate(left2) ||
				this.coordinate.isInSameCoordinate(down1) ||
				this.coordinate.isInSameCoordinate(down2);
	}
	
	public static void main(String[] args) {
		Knight knight = new Knight(new Coordinate(2, 2), Color.WHITE);
		
		Coordinate destiny = new Coordinate(3, 4);
		
		System.out.println(knight.canMove(destiny));
	}
}
