package masterMindWithFactoryMethod.views.graphics;

import masterMindWithFactoryMethod.views.MasterMindView;
import masterMindWithFactoryMethod.models.Board;

public class GraphicsView extends MasterMindView {
	
	public GraphicsView(Board board) {
		super(board);
	}

	@Override
	public void start() {
		// TODO
	}

	@Override
	public void play() {
		// TODO
	}

	@Override
	public boolean resume() {
		//TODO
		return false;
	}
	
	@Override
	public void winMessage() {
		//TODO
	}
	
	@Override
	public void loseMessage() {
		//TODO
	}

	@Override
	public boolean askUserPlayAgain() {
		//TODO
		return false;
	}
	
	@Override
	protected boolean isPlayingAgain(String input) {
		//TODO
		return false;
	}
	
	@Override
	protected boolean isGoodAnswer(String input) {
		//TODO
		return false;
	}
}
