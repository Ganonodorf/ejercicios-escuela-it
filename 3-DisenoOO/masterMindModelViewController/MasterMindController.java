package masterMindModelViewController;

import masterMindModelViewController.models.Board;
import masterMindModelViewController.models.MasterMind;
import masterMindModelViewController.views.MasterMindView;

public abstract class MasterMindController {
	private MasterMind masterMind;
	private MasterMindView masterMindView;
	private final int MAX_NUMBER_OF_ATTEMPS = 8;
	
	public MasterMindController() {
		masterMind = new MasterMind();
		masterMindView = createView(masterMind.getBoard());
	}
	
	abstract MasterMindView createView(Board board);
	
	public void play() {
		do {
			masterMindView.start();
			masterMindView.play();
		}while(masterMindView.resume());
	}
}
