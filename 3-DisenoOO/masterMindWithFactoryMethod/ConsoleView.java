package masterMindWithFactoryMethod;

import java.util.Scanner;

public class ConsoleView extends MasterMindView {
	
	public ConsoleView(){
		
	}
	
	@Override
	public void winMessage() {
		System.out.println("You've won!!! ;-)");
	}
	
	@Override
	public void loseMessage() {
		System.out.println("You've lost!!! :-(");
	}

	@Override
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
	
	@Override
	protected boolean isPlayingAgain(String input) {
		if(input.matches("y")) {
			return true;
		}
		return false;
	}
	
	@Override
	protected boolean isGoodAnswer(String input) {
		if(input.matches(ANSWER_REGEX)) {
			return true;
		}
		return false;
	}
}
