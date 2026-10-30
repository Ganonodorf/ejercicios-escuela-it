package masterMindModelViewController.views;

import masterMindModelViewController.models.Combination;
import masterMindModelViewController.models.MasterMind;
import masterMindModelViewController.utils.Observed;
import masterMindModelViewController.utils.Observer;

public abstract class MasterMindView extends Observed{
	
	protected MasterMind masterMind;
	
	public MasterMindView(MasterMind masterMind, Observer observer) {
		this.masterMind = masterMind;
		this.addObserver(observer);
		createMenu(masterMind, observer);
		createResume(observer);
	}
	
	public abstract void start();
	
	public abstract void board();
	
	protected abstract void createMenu(MasterMind masterMind, Observer observer);
	
	protected abstract void createResume(Observer observer);
	
	public abstract void menu();
	
	public abstract void askProposedCombination();
	
	public abstract Combination getPlayerCombination();
	
	public abstract void win();
	
	public abstract void lose();
	
	public abstract boolean resume();

	public void play() {
		start();
		
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