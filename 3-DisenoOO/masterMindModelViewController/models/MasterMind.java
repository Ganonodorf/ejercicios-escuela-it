package masterMindModelViewController.models;

import java.util.ArrayList;

public class MasterMind {
	
	private final int MAX_NUMBER_OF_ATTEMPS = 8;
	
	private Board board;
	
	private ArrayList<Memento> mementos;
	
	private int undoCount = 0;
	
	public MasterMind() {
		board = new Board(MAX_NUMBER_OF_ATTEMPS);
		
		mementos = new ArrayList<Memento>();
		
		saveState();
	}
	
	public void saveState() {
		if(undoCount > 0) {
			for(int i = undoCount; i > 0; i--) {
				mementos.removeFirst();
			}
		}
		
		mementos.addFirst(board.createMemento());
		
		undoCount = 0;
	}
	
	public boolean canUndo() {
		return board.numberOfAttempts() > 0;
	}
	
	public void undo() {
		undoCount += 1;
		
		board.setState(mementos.get(undoCount));
	}
	
	public boolean canRedo() {
		return undoCount > 0;
	}
	
	public void redo() {
		board.setState(mementos.get(undoCount - 1));
		
		undoCount -= 1;
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void reset() {
		board.initializeBoard();
		
		mementos = new ArrayList<Memento>();
		
		saveState();
	}
}
