package masterMindModelViewController.models;

import java.util.ArrayList;

public class MasterMind {
	
	private final int MAX_NUMBER_OF_ATTEMPS = 8;
	
	private Board board;
	
	private ArrayList<Memento> mementos;
	
	public MasterMind() {
		board = new Board(MAX_NUMBER_OF_ATTEMPS);
		
		mementos = new ArrayList<Memento>();
		
		saveState();
	}
	
	public void saveState() {
		mementos.addFirst(board.createMemento());
		
		for(Memento memento: mementos){
			memento.toString();
		}
	}
	
	public boolean canUndo() {
		return board.numberOfAttempts() > 0; 
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void undo() {
		mementos.removeFirst();
		
		board.setState(mementos.getFirst());
	}
	
	public void reset() {
		board.initializeBoard();
		
		mementos = new ArrayList<Memento>();
		
		saveState();
	}
}
