package masterMindModelViewController.views.console;

import java.util.ArrayList;
import java.util.Scanner;

import masterMindModelViewController.models.MasterMind;
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
	
	public MenuView(MasterMind masterMind, Observer observer) {
		super();
		choices = new ArrayList<Choice>();
		choices.add(new ProposeChoice(masterMind, observer));
		choices.add(new UndoChoice(masterMind, observer));
		choices.add(new RedoChoice(masterMind, observer));
	}
	
	@Override
	public void showInformation() {
		String input;
		
		Scanner scanner = new Scanner(System.in);
		
		boolean goodAnswer;
		
		ArrayList<Choice> availableChoices = new ArrayList<Choice>();
		
		for(Choice choice: choices) {
			if(choice.isActive()) {
				availableChoices.add(choice);
			}
		}

		do {
			System.out.println("Choose an option (number): ");
			
			for(int i = 0; i < availableChoices.size(); i++) {
				System.out.println(i + 1 + "-" + availableChoices.get(i).getName() + "");
			}
			
	        input = scanner.nextLine();
	        
	        goodAnswer = isGoodAnswer(input);
	        
	        if(!goodAnswer) {
	        	System.out.println("Not a valid answer. Try again.");
	        }
	        
		}while(!goodAnswer);
		
		int choiceNumber = Integer.parseInt(input);
		
		availableChoices.get(choiceNumber - 1).action();
	}
	
	private boolean isGoodAnswer(String input) {
		return input.matches(ANSWER_REGEX);
	}
}
