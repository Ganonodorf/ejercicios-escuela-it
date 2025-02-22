package Chess;

public class Bishop extends Piece{

	public Bishop(Coordinate coordinate, Color color) {
		super(coordinate, color);
		
		this.shape = color == Color.WHITE ? '♗' : '♝';
	}

	@Override
	public boolean canMove(Coordinate coordinate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canCapture(Coordinate coordinate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move(Coordinate coordinate) {
		// TODO Auto-generated method stub
		
	}

}
