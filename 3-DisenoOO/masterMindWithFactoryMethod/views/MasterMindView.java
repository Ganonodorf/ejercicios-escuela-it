package masterMindWithFactoryMethod.views;

import masterMindWithFactoryMethod.models.Board;

public abstract class MasterMindView {
	
	protected Board board;
	
	public MasterMindView(Board board) {
		this.board = board;
	}
	
	public abstract void start();
	
	public abstract void play();
	
	public abstract boolean resume();

}
