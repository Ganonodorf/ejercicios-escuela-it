package masterMindWithFactoryMethod.views;

import masterMindWithFactoryMethod.models.Board;
import masterMindWithFactoryMethod.views.console.BoardView;
import masterMindWithFactoryMethod.views.console.PlayerView;

public abstract class MasterMindView {
	protected final String ANSWER_REGEX = "^[yn]$";
	
	protected Board board;
	
	protected BoardView boardView;
	
	protected PlayerView playerView;
	
	public MasterMindView(Board board) {
		this.board = board;
		boardView = new BoardView(board);
		playerView = new PlayerView();
	}
	
	public abstract void start();
	
	public abstract void play();
	
	public abstract boolean resume();
	
	public abstract void winMessage();

	public abstract void loseMessage();
	
	public abstract boolean askUserPlayAgain();
	
	protected abstract boolean isPlayingAgain(String input);

	protected abstract boolean isGoodAnswer(String input);

}
