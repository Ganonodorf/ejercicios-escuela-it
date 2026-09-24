package masterMindWithFactoryMethod;

public abstract class MasterMind {
	private Board board;
	private MasterMindView masterMindView;
	private final int MAX_NUMBER_OF_ATTEMPS = 8;
	
	public MasterMind() {
		board = new Board(MAX_NUMBER_OF_ATTEMPS);
		masterMindView = createView(board);
	}
	
	abstract MasterMindView createView(Board board);
	
	public void play() {
		do {
			masterMindView.start();
			masterMindView.play();
		}while(masterMindView.resume());
	}
}
