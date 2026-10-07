package masterMindModelViewController.views;

import masterMindModelViewController.models.Board;

public abstract class ViewWithBoard extends View{
	
	protected Board board;
	
	public ViewWithBoard(Board board) {
		super();
		
		this.board = board;
	}
}
