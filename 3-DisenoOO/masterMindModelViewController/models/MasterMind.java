package masterMindModelViewController.models;

public class MasterMind {
	
	private Board board;
	private final int MAX_NUMBER_OF_ATTEMPS = 8;
	
	public MasterMind() {
		board = new Board(MAX_NUMBER_OF_ATTEMPS);
	}
	
	public Board getBoard() {
		return board;
	}
}
