package Chess;

public class Knight extends Piece{

	public Knight(Coordinate coordinate, Color color) {
		super(coordinate, color);
		
		this.shape = color == Color.WHITE ? '♘' : '♞';
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
		
		return coordinate.isInSameCoordinate(up1) || 
				coordinate.isInSameCoordinate(up2) ||
				coordinate.isInSameCoordinate(right1) ||
				coordinate.isInSameCoordinate(right2) ||
				coordinate.isInSameCoordinate(left1) ||
				coordinate.isInSameCoordinate(left2) ||
				coordinate.isInSameCoordinate(down1) ||
				coordinate.isInSameCoordinate(down2);
	}
}
