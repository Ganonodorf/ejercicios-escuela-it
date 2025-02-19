package Chess;

public class Board {
	
	private Piece[][] pieces;
	
	private boolean gameOver = false;
	
	private String winner = "nobody";
	
	public Board() {
		pieces = new Piece[8][8];
		
		this.createPieces();
	}
	
	public boolean canMovePiece(Piece piece, Coordinate coordinate) {
		return false;
	}
	
	public void movePiece(Piece piece, Coordinate coordinate) {
		
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
