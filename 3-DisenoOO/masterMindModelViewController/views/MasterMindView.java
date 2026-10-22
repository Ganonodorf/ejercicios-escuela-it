package masterMindModelViewController.views;

import masterMindModelViewController.models.Board;
import masterMindModelViewController.models.Combination;

public abstract class MasterMindView {
	
	protected Board board; 
	
	public MasterMindView(Board board) {
		this.board = board;
	}
	
	public abstract void start();
	
	public abstract void board();
	
	public abstract void player();
	
	public abstract Combination getPlayerCombination();
	
	public abstract void win();
	
	public abstract void lose();
	
	public abstract boolean resume();

}