package masterMindModelViewController;

import masterMindModelViewController.controllers.GameController;
import masterMindModelViewController.models.Board;
import masterMindModelViewController.models.MasterMind;
import masterMindModelViewController.utils.Event;
import masterMindModelViewController.utils.Observer;
import masterMindModelViewController.views.MasterMindView;

public abstract class MasterMindController implements Observer {
	private MasterMind masterMind;
	private MasterMindView masterMindView;
	private GameController gameController;
	
	public MasterMindController() {
		masterMind = new MasterMind();
		masterMindView = createView(masterMind.getBoard(), this);
		gameController = new GameController(masterMind.getBoard(), masterMindView);
	}
	
	abstract MasterMindView createView(Board board, Observer observer);
	
	public void play() {
		do {
			masterMindView.start();
			masterMindView.play();
		}while(masterMindView.resume());
	}
	
	@Override
	public void Update(Event event) {
		switch(event) {
		case Event.Propose:
			gameController.proposeCombination();
			break;
		case Event.Undo:
			break;
		case Event.Redo:
			break;
		}
	}
}
