package Chess;

public class Board {
	
	private Piece[][] spaces;
	
	private boolean gameOver = false;
	
	private String winner = "nobody";
	
	public Board() {
		spaces = new Piece[8][8];
		
		this.createPieces();
	}
	
	private Piece pieceIn(Coordinate coordinate) {
		return spaces[coordinate.getX()][coordinate.getY()];
	}
	
	private void deletePieceOfBoard(Piece piece) {
		spaces[piece.coordinate.getX()][piece.coordinate.getY()] = null;
	}
	
	private void putPiece(Piece piece) {
		spaces[piece.coordinate.getX()][piece.coordinate.getY()] = piece;
	}
	
	private boolean isPiece(Coordinate coordinate) {
		return pieceIn(coordinate) != null;
	}
	
	private boolean canMovePiece(Coordinate origin, Coordinate destiny) {
		return pieceIn(origin).canMove(destiny) &&
				!isAPieceOnTheWay(origin, destiny);
	}
	
	private boolean canCapturePiece(Coordinate origin, Coordinate destiny) {
		return pieceIn(origin).canMove(destiny) &&
				!isAPieceOnTheWay(origin, destiny) &&
				!pieceIn(origin).shareColor(pieceIn(destiny));
	}
	
	private boolean isAPieceOnTheWay(Coordinate origin, Coordinate destiny) {
		int initialNumber;
		int finalNumber;
		
		if(origin.isInSameColumn(destiny)) {
			initialNumber = origin.getY() < destiny.getY() ? origin.getY() : destiny.getY();
			finalNumber = origin.getY() > destiny.getY() ? origin.getY() : destiny.getY();
			
			for(int i = initialNumber; i <= finalNumber; i++) {
				if(spaces[origin.getX()][i] != null) {
					return true;
				}
			}
		}
		else if(origin.isInSameRow(destiny)) {
			initialNumber = origin.getX() < destiny.getX() ? origin.getX() : destiny.getX();
			finalNumber = origin.getX() > destiny.getX() ? origin.getX() : destiny.getX();
			
			for(int i = initialNumber; i <= finalNumber; i++) {
				if(spaces[origin.getY()][i] != null) {
					return true;
				}
			}
		}
		else if(origin.isInPrimaryDiagonal(destiny)) {
			Coordinate countOrigin = origin;
			Coordinate countDestiny = destiny;
			
			if(origin.getX() > destiny.getX()) {
				countOrigin = destiny;
				countDestiny = origin;
			}
			
			for(int i = 0; i <= countDestiny.getX() - countOrigin.getX(); i++) {
				if(spaces[countOrigin.getX() + i][countOrigin.getY() + i] != null) {
					return true;
				}
			}
		}
		else if(origin.isInSecondaryDiagonal(destiny)) {
			Coordinate countOrigin = origin;
			Coordinate countDestiny = destiny;
			
			if(origin.getX() > destiny.getX()) {
				countOrigin = destiny;
				countDestiny = origin;
			}
			
			for(int i = 0; i <= countDestiny.getX() - countOrigin.getX(); i++) {
				if(spaces[countOrigin.getX() + i][countOrigin.getY() - i] != null) {
					return true;
				}
			}
		}
		
		return false;
	}

	private void movePiece(Coordinate origin, Coordinate destiny) {
		Piece piece = pieceIn(origin);
		
		this.deletePieceOfBoard(piece);
		
		piece.move(destiny);
		
		this.putPiece(piece);
	}
	
	public boolean isGameOver() {
		return gameOver;
	}
	
	public String result() {
		return "The winner is " + winner;
	}

	private void createPieces() {
		for(int i = 0; i < 8; i++) {
			spaces[1][i] = new Pawn(new Coordinate(1, i), Color.WHITE);
			spaces[6][i] = new Pawn(new Coordinate(6, i), Color.BLACK);
		}
		
		spaces[0][0] = new Rook(new Coordinate(0, 0), Color.WHITE);
		spaces[0][7] = new Rook(new Coordinate(0, 7), Color.WHITE);
		
		spaces[0][1] = new Knight(new Coordinate(0, 1), Color.WHITE);
		spaces[0][6] = new Knight(new Coordinate(0, 6), Color.WHITE);
		
		spaces[0][2] = new Bishop(new Coordinate(0, 2), Color.WHITE);
		spaces[0][5] = new Bishop(new Coordinate(0, 5), Color.WHITE);
		
		spaces[0][3] = new Queen(new Coordinate(0, 3), Color.WHITE);
		spaces[0][4] = new King(new Coordinate(0, 4), Color.WHITE);
		
		spaces[7][0] = new Rook(new Coordinate(0, 0), Color.BLACK);
		spaces[7][7] = new Rook(new Coordinate(0, 7), Color.BLACK);
		
		spaces[7][1] = new Knight(new Coordinate(0, 1), Color.BLACK);
		spaces[7][6] = new Knight(new Coordinate(0, 6), Color.BLACK);
		
		spaces[7][2] = new Bishop(new Coordinate(0, 2), Color.BLACK);
		spaces[7][5] = new Bishop(new Coordinate(0, 5), Color.BLACK);
		
		spaces[7][3] = new Queen(new Coordinate(0, 3), Color.BLACK);
		spaces[7][4] = new King(new Coordinate(0, 4), Color.BLACK);
	}

	public void showInformation() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(spaces[i][j] == null) {
					System.out.print("_");
				}
				else {
					spaces[i][j].Show();
				}
			}
		}
		
	}

	public boolean canMove(Move move) {
		Coordinate origin = move.piece.coordinate;
		Coordinate destiny = move.destiny;
		
		return isPiece(origin) && canMovePiece(origin, destiny);
	}

	public String getWinner() {
		return winner;
	}
}
