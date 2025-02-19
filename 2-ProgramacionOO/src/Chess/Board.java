package Chess;

public class Board {
	
	private Piece[][] pieces;
	
	private boolean gameOver = false;
	
	private String winner = "nobody";
	
	public Board() {
		pieces = new Piece[8][8];
		
		this.createPieces();
	}
	
	private Piece pieceIn(Coordinate coordinate) {
		return pieces[coordinate.getX()][coordinate.getY()];
	}
	
	public boolean isPiece(Coordinate coordinate) {
		return pieceIn(coordinate) != null;
	}
	
	public boolean canMovePiece(Coordinate origin, Coordinate destiny) {
		return pieceIn(origin).canMove(destiny) &&
				!isAPieceOnTheWay(origin, destiny);
	}
	
	public boolean canCapturePiece(Coordinate origin, Coordinate destiny) {
		return pieceIn(origin).canMove(destiny) &&
				!isAPieceOnTheWay(origin, destiny) &&
				!pieceIn(origin).shareColor(pieceIn(destiny));
	}
	
	private boolean isAPieceOnTheWay(Coordinate origin, Coordinate destiny) {
		int distance = origin.distance(destiny);
		
		int initialNumber;
		int finalNumber;
		
		if(origin.isInSameColumn(destiny)) {
			initialNumber = origin.getY() < destiny.getY() ? origin.getY() : destiny.getY();
			finalNumber = origin.getY() > destiny.getY() ? origin.getY() : destiny.getY();
			
			for(int i = initialNumber; i <= finalNumber; i++) {
				if(pieces[origin.getX()][i] != null) {
					return true;
				}
			}
		}
		else if(origin.isInSameRow(destiny)) {
			initialNumber = origin.getX() < destiny.getX() ? origin.getX() : destiny.getX();
			finalNumber = origin.getX() > destiny.getX() ? origin.getX() : destiny.getX();
			
			for(int i = initialNumber; i <= finalNumber; i++) {
				if(pieces[origin.getY()][i] != null) {
					return true;
				}
			}
		}
		else if(origin.isInPrimaryDiagonal(destiny)) {
			initialNumber = origin.getX() < destiny.getX() ? origin.getX() : destiny.getX();
			finalNumber = origin.getX() > destiny.getX() ? origin.getX() : destiny.getX();
			
			for(int i = initialNumber; i <= finalNumber; i++) {
				int paso = initialNumber + (initialNumber - i);
				if(pieces[][i] != null) {
					return true;
				}
			}
		}
		else {
			initialNumber = origin.getX() < destiny.getX() ? origin.getX() : destiny.getX();
			finalNumber = origin.getX() > destiny.getX() ? origin.getX() : destiny.getX();
		}
		
		for(int i = initialNumber; i <= finalNumber; i++) {
			
		}
		return false;
	}

	public void movePiece(Coordinate origin, Coordinate destiny) {
		pieceIn(origin).move(destiny);
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public String result() {
		return "The winner is " + winner;
	}

	private void createPieces() {
		for(int i = 0; i < 8; i++) {
			pieces[1][i] = new Pawn(new Coordinate(1, i), Color.WHITE);
			pieces[6][i] = new Pawn(new Coordinate(6, i), Color.BLACK);
		}
		
		pieces[0][0] = new Rook(new Coordinate(0, 0), Color.WHITE);
		pieces[0][7] = new Rook(new Coordinate(0, 7), Color.WHITE);
		
		pieces[0][1] = new Knight(new Coordinate(0, 1), Color.WHITE);
		pieces[0][6] = new Knight(new Coordinate(0, 6), Color.WHITE);
		
		pieces[0][2] = new Bishop(new Coordinate(0, 2), Color.WHITE);
		pieces[0][5] = new Bishop(new Coordinate(0, 5), Color.WHITE);
		
		pieces[0][3] = new Queen(new Coordinate(0, 3), Color.WHITE);
		pieces[0][4] = new King(new Coordinate(0, 4), Color.WHITE);
		
		pieces[7][0] = new Rook(new Coordinate(0, 0), Color.BLACK);
		pieces[7][7] = new Rook(new Coordinate(0, 7), Color.BLACK);
		
		pieces[7][1] = new Knight(new Coordinate(0, 1), Color.BLACK);
		pieces[7][6] = new Knight(new Coordinate(0, 6), Color.BLACK);
		
		pieces[7][2] = new Bishop(new Coordinate(0, 2), Color.BLACK);
		pieces[7][5] = new Bishop(new Coordinate(0, 5), Color.BLACK);
		
		pieces[7][3] = new Queen(new Coordinate(0, 3), Color.BLACK);
		pieces[7][4] = new King(new Coordinate(0, 4), Color.BLACK);
		
	}
}
