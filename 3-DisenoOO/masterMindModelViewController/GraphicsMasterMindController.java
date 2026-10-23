package masterMindModelViewController;

import masterMindModelViewController.models.Board;
import masterMindModelViewController.utils.Observer;
import masterMindModelViewController.views.MasterMindView;
import masterMindModelViewController.views.graphics.GraphicsView;

public class GraphicsMasterMindController extends MasterMindController {
	
	@Override
	public MasterMindView createView(Board board, Observer observer) {
		return new GraphicsView(board, observer);
	}

	public static void main(String[] args) {
		MasterMindController masterMindController = new GraphicsMasterMindController();
		
		masterMindController.play();
	}
}
