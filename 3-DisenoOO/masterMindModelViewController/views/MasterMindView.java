package masterMindModelViewController.views;

import masterMindModelViewController.models.Board;
import masterMindModelViewController.models.Combination;

public abstract class MasterMindView {
	
	public MasterMindView() {
		
	}
	
	public abstract void start();
	
	public abstract void board(Board board);
	
	public abstract void player();
	
	public abstract Combination getPlayerCombination();
	
	public abstract void win();
	
	public abstract void lose();
	
	public abstract boolean resume();

}