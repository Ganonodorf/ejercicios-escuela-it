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
		if(pieceIn(origin).shareType(new Knight(new Coordinate(0, 0), Color.WHITE))) {
			return pieceIn(origin).canMove(destiny) && pieceIn(destiny) == null;
		}
		
		return pieceIn(origin).canMove(destiny) &&
				!isAPieceOnTheWay(origin, destiny);
	}
	
	/*
	private boolean canCapturePiece(Coordinate origin, Coordinate destiny) {
		return pieceIn(origin).canMove(destiny) &&
				!isAPieceOnTheWay(origin, destiny) &&
				!pieceIn(origin).shareColor(pieceIn(destiny));
	}
	*/
	
	private boolean isAPieceOnTheWay(Coordinate origin, Coordinate destiny) {
		Coordinate[] coordinatesOnTheWay = origin.coordinatesTo(destiny);
		
		for(Coordinate coordinate : coordinatesOnTheWay) {
			if(this.pieceIn(coordinate) != null) {
				return true;
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
			spaces[i][1] = new Pawn(new Coordinate(i, 1), Color.WHITE);
			spaces[i][6] = new Pawn(new Coordinate(i, 6), Color.BLACK);
		}
		
		spaces[0][0] = new Rook(new Coordinate(0, 0), Color.WHITE);
		spaces[7][0] = new Rook(new Coordinate(7, 0), Color.WHITE);
		
		spaces[1][0] = new Knight(new Coordinate(1, 0), Color.WHITE);
		spaces[6][0] = new Knight(new Coordinate(6, 0), Color.WHITE);
		
		spaces[2][0] = new Bishop(new Coordinate(2, 0), Color.WHITE);
		spaces[5][0] = new Bishop(new Coordinate(5, 0), Color.WHITE);
		
		spaces[3][0] = new Queen(new Coordinate(3, 0), Color.WHITE);
		spaces[4][0] = new King(new Coordinate(4, 0), Color.WHITE);
		
		spaces[0][7] = new Rook(new Coordinate(0, 7), Color.BLACK);
		spaces[7][7] = new Rook(new Coordinate(7, 7), Color.BLACK);
		
		spaces[1][7] = new Knight(new Coordinate(1, 7), Color.BLACK);
		spaces[6][7] = new Knight(new Coordinate(6, 7), Color.BLACK);
		
		spaces[2][7] = new Bishop(new Coordinate(2, 7), Color.BLACK);
		spaces[5][7] = new Bishop(new Coordinate(5, 7), Color.BLACK);
		
		spaces[3][7] = new Queen(new Coordinate(3, 7), Color.BLACK);
		spaces[4][7] = new King(new Coordinate(4, 7), Color.BLACK);
	}

	public void showInformation() {
		for(int i = 7; i >= 0; i--) {
			System.out.print(i + 1 + " ");
			
			for(int j = 0; j < 8; j++) {
				if(spaces[j][i] == null) {
					System.out.print("_");
				}
				else {
					spaces[j][i].Show();
				}
				System.out.print(" ");
			}
			
			System.out.print("\n");
		}
		
		System.out.print("  a b c d e f g h\n\n");
	}

	public boolean canMakeMovement(Movement movement) {
		Coordinate origin = movement.piece.coordinate;
		Coordinate destiny = movement.destiny;
		
		if(!isPiece(origin)) {
			System.out.println("\nThere is no piece there.");
		}
		if(isPiece(origin) && !canMovePiece(origin, destiny)) {
			System.out.println("\nPiece can't be moved there.");
		}
		
		return isPiece(origin) && canMovePiece(origin, destiny);
	}

	public void makeMovement(Movement movement) {
		Coordinate origin = movement.piece.coordinate;
		Coordinate destiny = movement.destiny;
		
		this.movePiece(origin, destiny);
	}

	public String getWinner() {
		return winner;
	}
	
	public static void main(String[] args) {
		Board board = new Board();
		
		board.showInformation();
		
		Movement movement = new Movement("pd2d3", Color.WHITE);
		
		board.makeMovement(movement);
		
		board.showInformation();
		

		movement = new Movement("bc1e3", Color.WHITE);
		
		System.out.println(board.canMakeMovement(movement));
	}
}
