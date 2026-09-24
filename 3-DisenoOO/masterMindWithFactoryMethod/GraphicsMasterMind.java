package masterMindWithFactoryMethod;

import masterMindWithFactoryMethod.models.Board;
import masterMindWithFactoryMethod.views.MasterMindView;
import masterMindWithFactoryMethod.views.graphics.GraphicsView;

public class GraphicsMasterMind extends MasterMind {
	
	@Override
	public MasterMindView createView(Board board) {
		return new GraphicsView(board);
	}

	public static void main(String[] args) {
		MasterMind masterMind = new GraphicsMasterMind();
		
		masterMind.play();
	}
}
