package masterMindWithFactoryMethod.views;

import masterMindWithFactoryMethod.models.Board;

public abstract class ViewWithBoard extends View{
	
	protected Board board;
	
	public ViewWithBoard(Board board) {
		super();
		
		this.board = board;
	}
}
