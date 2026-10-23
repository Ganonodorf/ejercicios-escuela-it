package masterMindModelViewController.views.console;

import masterMindModelViewController.views.MasterMindView;
import masterMindModelViewController.models.Board;
import masterMindModelViewController.models.Combination;
import masterMindModelViewController.utils.Observer;

public class ConsoleView extends MasterMindView {
	private ProposeCombinationView proposeCombinationView;
	private MenuView menuView;
	private WinView winView;
	private LoseView loseView;
	private StartView startView;
	private PlayAgainView playAgainView;
	
	public ConsoleView(Board board, Observer observer){
		proposeCombinationView = new ProposeCombinationView();
		winView = new WinView();
		loseView = new LoseView();
		startView = new StartView();
		playAgainView = new PlayAgainView();
		super(board, observer);
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
	protected void createMenu(Observer observer) {
		menuView = new MenuView(observer);
	}

	@Override
	public void menu() {
		menuView.showInformation();
	}

	@Override
	public void askProposedCombination() {
		proposeCombinationView.showInformation();
	}

	@Override
	public Combination getPlayerCombination() {
		return proposeCombinationView.getPlayerCombination();
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
