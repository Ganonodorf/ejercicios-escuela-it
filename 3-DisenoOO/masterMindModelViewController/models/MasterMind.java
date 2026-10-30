package masterMindModelViewController.models;

import java.util.ArrayList;

public class MasterMind {
	
	private final int MAX_NUMBER_OF_ATTEMPS = 8;
	
	private Board board;
	
	private ArrayList<Memento> mementos;
	
	public MasterMind() {
		reset();
	}
	
	public void saveState() {
		mementos.addFirst(board.createMemento());
	}
	
	public boolean canUndo() {
		return board.numberOfAttempts() > 0; 
	}
	
	public Board getBoard() {
		return board;
	}
}
