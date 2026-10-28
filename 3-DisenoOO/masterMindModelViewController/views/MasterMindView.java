package masterMindModelViewController.views;

import masterMindModelViewController.models.Board;
import masterMindModelViewController.models.Combination;
import masterMindModelViewController.utils.Observer;

public abstract class MasterMindView {
	
	protected Board board;
	
	public MasterMindView(Board board, Observer observer) {
		this.board = board;
		createMenu(observer);
	}
	
	public abstract void start();
	
	public abstract void board();
	
	protected abstract void createMenu(Observer observer);
	
	public abstract void menu();
	
	public abstract void askProposedCombination();
	
	public abstract Combination getPlayerCombination();
	
	public abstract void win();
	
	public abstract void lose();
	
	public abstract boolean resume();

	public void play() {
		start();
		
		board.initializeBoard();
		
		do {
			board();
			
			menu();
			
		}while(board.hasMoreAttempts() && board.isWinnerResult() == false);

		board();
		
		if(board.isWinnerResult()) {
			win();
		}
		else {
			lose();
		}
	}

}