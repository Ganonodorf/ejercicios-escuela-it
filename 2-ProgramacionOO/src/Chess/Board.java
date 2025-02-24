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
			
			for(int i = initialNumber + 1; i <= finalNumber; i++) {
				if(spaces[origin.getX()][i] != null) {
					return true;
				}
			}
		}
		else if(origin.isInSameRow(destiny)) {
			initialNumber = origin.getX() < destiny.getX() ? origin.getX() : destiny.getX();
			finalNumber = origin.getX() > destiny.getX() ? origin.getX() : destiny.getX();
			
			for(int i = initialNumber + 1; i <= finalNumber; i++) {
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
			spaces[i][1] = new Pawn(new Coordinate(1, i), Color.WHITE);
			spaces[i][6] = new Pawn(new Coordinate(6, i), Color.BLACK);
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

	public boolean canMove(Move move) {
		Coordinate origin = move.piece.coordinate;
		Coordinate destiny = move.destiny;
		
		return isPiece(origin) && canMovePiece(origin, destiny);
	}

	public String getWinner() {
		return winner;
	}
	
	public static void main(String[] args) {
		Board board = new Board();
		
		board.showInformation();

		Player player = new Player(Color.WHITE);
		
		Move move = new Move("pc2c3", Color.WHITE);
		

		System.out.println("Spaces: " + board.spaces[2][1]);
		System.out.println("Is piece: " + board.isPiece(move.piece.coordinate));
		System.out.println("Piece in: " + board.pieceIn(move.piece.coordinate));
		System.out.println("move.piece.coordinate: " + move.piece.coordinate.getX() + " " + move.piece.coordinate.getY());
		System.out.println("move.destiny: " + move.destiny.getX() + " " + move.destiny.getY());
		System.out.println("Piece in can move: " + board.pieceIn(move.piece.coordinate).canMove(move.destiny));
		System.out.println("Is a p on the way: " + board.isAPieceOnTheWay(move.piece.coordinate, move.destiny));
		System.out.println("Can move p: " + board.canMovePiece(move.piece.coordinate, move.destiny));
		System.out.println("Can move: " + board.canMove(move));

		//System.out.println(board.canMovePiece(move.piece.coordinate, move.destiny));
	}
}
