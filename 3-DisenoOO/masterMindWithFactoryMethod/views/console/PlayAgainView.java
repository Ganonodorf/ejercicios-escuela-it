package masterMindWithFactoryMethod.views.console;

import java.util.Scanner;

import masterMindWithFactoryMethod.views.View;

public class PlayAgainView extends View{
	
	private final String ANSWER_REGEX = "^[yn]$";
	
	private final String PLAY_AGAIN = "y";
	
	private boolean isPlayingAgain;
	
	public PlayAgainView() {
		super();
	}

	@Override
	public void showInformation() {
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
		
		isPlayingAgain = inputMatchesPlayAgain(input);
	}
	
	public boolean isPlayingAgain() {
		return isPlayingAgain;
	}
	
	private boolean inputMatchesPlayAgain(String input) {
		return input.matches(PLAY_AGAIN);
	}
	
	private boolean isGoodAnswer(String input) {
		return input.matches(ANSWER_REGEX);
	}
}
