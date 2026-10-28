package masterMindModelViewController.views;

import masterMindModelViewController.models.Combination;
import masterMindModelViewController.models.MasterMind;
import masterMindModelViewController.utils.Observer;

public abstract class MasterMindView {
	
	protected MasterMind masterMind;
	
	public MasterMindView(MasterMind masterMind, Observer observer) {
		this.masterMind = masterMind;
		createMenu(masterMind, observer);
	}
	
	public abstract void start();
	
	public abstract void board();
	
	protected abstract void createMenu(MasterMind masterMind, Observer observer);
	
	public abstract void menu();
	
	public abstract void askProposedCombination();
	
	public abstract Combination getPlayerCombination();
	
	public abstract void win();
	
	public abstract void lose();
	
	public abstract boolean resume();

	public void play() {
		start();
		
		masterMind.getBoard().initializeBoard();
		
		do {
			board();
			
			menu();
			
		}while(masterMind.getBoard().hasMoreAttempts() && masterMind.getBoard().isWinnerResult() == false);

		board();
		
		if(masterMind.getBoard().isWinnerResult()) {
			win();
		}
		else {
			lose();
		}
	}

}