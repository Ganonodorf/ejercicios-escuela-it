package masterMindWithFactoryMethod.views;

import masterMindWithFactoryMethod.models.Board;

public abstract class BoardView {
	
	protected Board board;
	
	public BoardView(Board board) {
		this.board = board;
	}
	
	public abstract void showInformation();
}
