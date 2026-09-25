package masterMindWithFactoryMethod.views.console;

import masterMindWithFactoryMethod.views.MasterMindView;
import masterMindWithFactoryMethod.models.Board;
import masterMindWithFactoryMethod.models.Combination;

public class ConsoleView extends MasterMindView {
	
	private BoardView consoleBoardView;
	private PlayerView playerView;
	private WinView winView;
	private LoseView loseView;
	private StartView startView;
	private PlayAgainView playAgainView;
	
	public ConsoleView(Board board){
		super(board);
		consoleBoardView = new BoardView(board);
		playerView = new PlayerView();
		winView = new WinView();
		loseView = new LoseView();
		startView = new StartView();
		playAgainView = new PlayAgainView();
	}
	
	@Override
	public void start() {
		startView.showInformation();
	}
	
	@Override
	public void play() {
		board.initializeBoard();
		
		consoleBoardView = new BoardView(board);
		
		do {
			consoleBoardView.showInformation();
			
			playerView.showInformation();
			
			Combination proposedCombination = playerView.getPlayerCombination();
			
			board.proposeCombination(proposedCombination);
			
		}while(board.hasMoreAttempts() && board.isWinnerResult() == false);

		consoleBoardView.showInformation();
		
		if(board.isWinnerResult()) {
			winView.showInformation();
		}
		else {
			loseView.showInformation();
		}
	}

	@Override
	public boolean resume() {
		playAgainView.showInformation();
		
		return playAgainView.isPlayingAgain();
	}
}
