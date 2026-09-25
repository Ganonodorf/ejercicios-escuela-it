package masterMindWithFactoryMethod.views.console;

import java.util.Scanner;

import masterMindWithFactoryMethod.views.MasterMindView;
import masterMindWithFactoryMethod.models.Board;
import masterMindWithFactoryMethod.models.Combination;

public class ConsoleView extends MasterMindView {
	
	private final String ANSWER_REGEX = "^[yn]$";
	
	private BoardView consoleBoardView;
	private PlayerView playerView;
	private WinView winView;
	private LoseView loseView;
	private StartView startView;
	
	public ConsoleView(Board board){
		super(board);
		consoleBoardView = new BoardView(board);
		playerView = new PlayerView();
		winView = new WinView();
		loseView = new LoseView();
		startView = new StartView();
	}
	
	@Override
	public void start() {
		startView.showInformation();
	}
	
	@Override
	public void play() {
		board.initializeBoard();
		
		consoleBoardView = new BoardView(board);
		
		do {
			consoleBoardView.showInformation();
			
			playerView.showInformation();
			
			Combination proposedCombination = playerView.getPlayerCombination();
			
			board.proposeCombination(proposedCombination);
			
		}while(board.hasMoreAttempts() && board.isWinnerResult() == false);

		consoleBoardView.showInformation();
		
		if(board.isWinnerResult()) {
			winView.showInformation();
		}
		else {
			loseView.showInformation();
		}
	}

	@Override
	public boolean resume() {
		return this.askUserPlayAgain();
	}

	public boolean askUserPlayAgain() {
		String input;
		
		Scanner scanner = new Scanner(System.in);
		
		boolean goodAnswer;
		
		System.out.println("Do you want to continue? (y/n): ");

		do {
	        input = scanner.nextLine();
	        
	        goodAnswer = isGoodAnswer(input);
	        
	        if(!goodAnswer) {
	        	System.out.println("Not a valid answer. Try again.");
	        }
	        
		}while(!goodAnswer);
		
		return isPlayingAgain(input);
	}
	
	protected boolean isPlayingAgain(String input) {
		return input.matches("y");
	}
	
	protected boolean isGoodAnswer(String input) {
		return input.matches(ANSWER_REGEX);
	}
}
