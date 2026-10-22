package masterMindModelViewController.views.console;

import masterMindModelViewController.views.MasterMindView;
import masterMindModelViewController.models.Board;
import masterMindModelViewController.models.Combination;

public class ConsoleView extends MasterMindView {
	private PlayerView playerView;
	private WinView winView;
	private LoseView loseView;
	private StartView startView;
	private PlayAgainView playAgainView;
	
	public ConsoleView(Board board){
		playerView = new PlayerView();
		winView = new WinView();
		loseView = new LoseView();
		startView = new StartView();
		playAgainView = new PlayAgainView();
		super(board);
	}
	
	@Override
	public void start() {
		startView.showInformation();
	}

	
	@Override
	public void board() {
		new BoardView(this.board).showInformation();
	}

	@Override
	public void player() {
		playerView.showInformation();
	}

	@Override
	public Combination getPlayerCombination() {
		return playerView.getPlayerCombination();
	}

	@Override
	public void win() {
		winView.showInformation();
		
	}

	@Override
	public void lose() {
		loseView.showInformation();
		
	}

	@Override
	public boolean resume() {
		playAgainView.showInformation();
		
		return playAgainView.isPlayingAgain();
	}

}
