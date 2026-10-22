package masterMindModelViewController;

import masterMindModelViewController.models.Board;
import masterMindModelViewController.views.MasterMindView;
import masterMindModelViewController.views.graphics.GraphicsView;

public class GraphicsMasterMindController extends MasterMindController {
	
	@Override
	public MasterMindView createView(Board board) {
		return new GraphicsView();
	}

	public static void main(String[] args) {
		MasterMindController masterMindController = new GraphicsMasterMindController();
		
		masterMindController.play();
	}
}
