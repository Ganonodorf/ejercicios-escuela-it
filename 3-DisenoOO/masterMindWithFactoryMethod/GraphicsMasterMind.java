package masterMindWithFactoryMethod;

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
