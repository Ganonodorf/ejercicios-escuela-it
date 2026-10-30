package masterMindModelViewController.models;

import java.util.ArrayList;

public class Memento {
	
	int attempts;
	
	private ArrayList<Play> plays;
	
	public Memento(int attempts, ArrayList<Play> plays) {
		this.attempts = attempts;
		this.plays = plays;
	}
	
	public Play getPlay(int number) {
		return plays.get(number);
	}
	
	public int getAttempts() {
		return attempts;
	}
	
	public String toString() {
		String result = "";
		
		result = result + "Attempts: " + attempts + "/n";
		
		for(int i = 0; i < plays.size(); i++) {
			result = result + plays.get(i).toString() + "/n";
		}
		
		return result;
	}
}
