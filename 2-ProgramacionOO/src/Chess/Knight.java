package Chess;

public class Knight extends Piece{

	public Knight(Coordinate coordinate, Color color) {
		super(coordinate, color);
		
		this.shape = color == Color.WHITE ? '♘' : '♞';
	}

	@Override
	public boolean canMove(Coordinate coordinate) {
		Coordinate up1 = this.coordinate.clone();
		up1.move(1, 2);
		Coordinate up2 = this.coordinate.clone();
		up2.move(-1, 2);

		Coordinate right1 = this.coordinate.clone();
		right1.move(2, 1);
		Coordinate right2 = this.coordinate.clone();
		right2.move(2, -1);
		
		Coordinate down1 = this.coordinate.clone();
		up1.move(1, -2);
		Coordinate down2 = this.coordinate.clone();
		up2.move(-1, -2);

		Coordinate left1 = this.coordinate.clone();
		right1.move(-2, 1);
		Coordinate left2 = this.coordinate.clone();
		right2.move(-2, -1);
		
		return coordinate == up1 || 
				coordinate == up2 ||
				coordinate == right1 ||
				coordinate == right2 ||
				coordinate == left1 ||
				coordinate == left2 ||
				coordinate == down1 ||
				coordinate == down2;
	}
}
