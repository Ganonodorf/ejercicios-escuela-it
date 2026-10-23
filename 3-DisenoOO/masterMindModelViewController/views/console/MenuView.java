package masterMindModelViewController.views.console;

import java.util.ArrayList;
import java.util.Scanner;

import masterMindModelViewController.utils.Event;
import masterMindModelViewController.utils.Observer;
import masterMindModelViewController.views.Choice;
import masterMindModelViewController.views.ProposeChoice;
import masterMindModelViewController.views.RedoChoice;
import masterMindModelViewController.views.UndoChoice;
import masterMindModelViewController.views.View;

public class MenuView extends View{
	
	private ArrayList<Choice> choices;
	
	private String ANSWER_REGEX = "^[1-9]"; 
	
	public MenuView(Observer observer) {
		choices = new ArrayList<Choice>();
		choices.add(new ProposeChoice(observer));
		//choices.add(new UndoChoice(observer));
		//choices.add(new RedoChoice(observer));
	}
	
	@Override
	public void showInformation() {
		String input;
		
		Scanner scanner = new Scanner(System.in);
		
		boolean goodAnswer;

		do {
			System.out.println("Choose an option (number): ");
			
			for(int i = 0; i < choices.size(); i++) {
				System.out.println(i + 1 + "-" + choices.get(i).getName() + "");
			}
			
	        input = scanner.nextLine();
	        
	        goodAnswer = isGoodAnswer(input);
	        
	        if(!goodAnswer) {
	        	System.out.println("Not a valid answer. Try again.");
	        }
	        
		}while(!goodAnswer);
		
		int choiceNumber = Integer.parseInt(input);
		
		executeChoice(choiceNumber);
	}
	
	private void executeChoice(int input) {
		choices.get(input - 1).action();
	}
	
	private boolean isGoodAnswer(String input) {
		return input.matches(ANSWER_REGEX);
	}
}
