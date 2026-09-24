package masterMindWithFactoryMethod;

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
