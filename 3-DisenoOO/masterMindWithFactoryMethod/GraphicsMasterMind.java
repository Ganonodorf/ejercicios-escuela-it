package masterMindWithFactoryMethod;

public class GraphicsMasterMind extends MasterMind {
	
	@Override
	public MasterMindView createView() {
		return new GraphicsView();
	}

	public static void main(String[] args) {
		MasterMind masterMind = new GraphicsMasterMind();
		
		masterMind.play();
	}
}
