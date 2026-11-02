package masterMindModelViewController.models;

import java.util.ArrayList;

public class MasterMind {
	
	private final int MAX_NUMBER_OF_ATTEMPS = 8;
	
	private Board board;
	
	private ArrayList<Memento> mementos;
	
	private ArrayList<Memento> backupMementos;
	
	private int redoCount = 0;
	
	public MasterMind() {
		board = new Board(MAX_NUMBER_OF_ATTEMPS);
		
		mementos = new ArrayList<Memento>();
		
		backupMementos = new ArrayList<Memento>();
		
		saveState();
	}
	
	public void saveState() {		
		mementos.addFirst(board.createMemento());
		
		backupMementos.addFirst(board.createMemento());
		
		redoCount = 0;
	}
	
	public boolean canUndo() {
		return board.numberOfAttempts() > 0;
	}
	
	public void undo() {
		mementos.removeFirst();
		
		board.setState(mementos.getFirst());
		
		redoCount += 1;
	}
	
	public boolean canRedo() {
		return redoCount > 0;
	}
	
	public void redo() {
		mementos.addFirst(backupMementos.get(redoCount - 1));
		
		board.setState(mementos.getFirst());
		
		redoCount -= 1;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void reset() {
		board.initializeBoard();
		
		mementos = new ArrayList<Memento>();
		
		backupMementos = new ArrayList<Memento>();
		
		saveState();
	}
}
