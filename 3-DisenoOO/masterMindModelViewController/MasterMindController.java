package masterMindModelViewController;

import masterMindModelViewController.controllers.GameController;
import masterMindModelViewController.models.Board;
import masterMindModelViewController.models.MasterMind;
import masterMindModelViewController.views.MasterMindView;

public abstract class MasterMindController {
	private MasterMind masterMind;
	private MasterMindView masterMindView;
	private GameController gameController;
	
	public MasterMindController() {
		masterMind = new MasterMind();
		masterMindView = createView(masterMind.getBoard());
		gameController = new GameController(masterMind.getBoard(), masterMindView);
	}
	
	abstract MasterMindView createView(Board board);
	
	public void play() {
		do {
			masterMindView.start();
			gameController.play();
		}while(masterMindView.resume());
	}
}
