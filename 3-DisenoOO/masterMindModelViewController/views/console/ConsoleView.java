package masterMindModelViewController.views.console;

import masterMindModelViewController.views.MasterMindView;
import masterMindModelViewController.models.Combination;
import masterMindModelViewController.models.MasterMind;
import masterMindModelViewController.utils.Event;
import masterMindModelViewController.utils.Observer;

public class ConsoleView extends MasterMindView {
	private ProposeCombinationView proposeCombinationView;
	private MenuView menuView;
	private WinView winView;
	private LoseView loseView;
	private StartView startView;
	private PlayAgainView playAgainView;
	
	public ConsoleView(MasterMind masterMind, Observer observer){
		super(masterMind, observer);
		proposeCombinationView = new ProposeCombinationView();
		winView = new WinView();
		loseView = new LoseView();
		startView = new StartView();
	}
	
	@Override
	public void start() {
		startView.showInformation();
	}

	
	@Override
	public void board() {
		new BoardView(masterMind.getBoard()).showInformation();
	}

	@Override
	protected void createMenu(MasterMind masterMind, Observer observer) {
		menuView = new MenuView(masterMind, observer);
	}

	@Override
	protected void createResume(Observer observer) {
		playAgainView = new PlayAgainView(observer);
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
		
		if(playAgainView.isPlayingAgain()) {
			this.notify(Event.NewGame);
		}
		
		return playAgainView.isPlayingAgain();
	}

}
