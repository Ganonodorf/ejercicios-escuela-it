package masterMindModelViewController.models;

import java.util.ArrayList;

public class MasterMind {
	
	private final int MAX_NUMBER_OF_ATTEMPS = 8;
	
	private Board board;
	
	private ArrayList<Memento> mementos;
	
	public MasterMind() {
		board = new Board(MAX_NUMBER_OF_ATTEMPS);
		mementos = new ArrayList<Memento>();
	}
	
	public void saveState() {
		Memento memento = new Memento(MAX_NUMBER_OF_ATTEMPS, board.getPlays());
	}
	
	public boolean canUndo() {
		return board.numberOfAttempts() > 0; 
	}
	
	public Board getBoard() {
		return board;
	}
}
