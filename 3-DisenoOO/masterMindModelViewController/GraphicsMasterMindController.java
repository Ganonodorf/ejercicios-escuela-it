package masterMindModelViewController;

import masterMindModelViewController.models.MasterMind;
import masterMindModelViewController.utils.Observer;
import masterMindModelViewController.views.MasterMindView;
import masterMindModelViewController.views.graphics.GraphicsView;

public class GraphicsMasterMindController extends MasterMindController {
	
	@Override
	public MasterMindView createView(MasterMind masterMind, Observer observer) {
		return new GraphicsView(masterMind, observer);
	}

	public static void main(String[] args) {
		MasterMindController masterMindController = new GraphicsMasterMindController();
		
		masterMindController.play();
	}
}
