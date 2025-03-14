package masterMindWithViews;

public class MasterMind {
	private PlayerView playerView;
	private Board board;
	private BoardView boardView;
	private MasterMindView masterMindView;
	private final int NUMBER_OF_ATTEMPS = 8;
	
	public MasterMind() {
		playerView = new PlayerView();
		masterMindView = new MasterMindView();
	}
	
	public void play() {
		do {
			board = new Board(NUMBER_OF_ATTEMPS);
			boardView = new BoardView(board);
			
			do {
				boardView.showInformation();
				
				Combination proposedCombination = playerView.askUserCombination();
				
				board.proposeCombination(proposedCombination);
				
			}while(board.numberOfAttempts() < NUMBER_OF_ATTEMPS && board.isWinnerResult() == false);

			boardView.showInformation();
			
			if(board.isWinnerResult()) {
				masterMindView.winMessage();
			}
			else {
				masterMindView.loseMessage();
			}
			
		}while(masterMindView.askUserPlayAgain() == true);
	}

	public static void main(String[] args) {
		MasterMind masterMind = new MasterMind();
		
		masterMind.play();
	}
}
