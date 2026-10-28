package masterMindModelViewController.models;

public class Memento {
	
	int attempts;
	
	private Play[] plays;
	
	public Memento(int attempts, Play[] plays) {
		this.attempts = attempts;
		this.plays = plays;
	}
	
	public Play getPlay(int number) {
		return plays[number];
	}
	
	public int getCurrentAttempt() {
		int currentAttempts = 0;
		
		for(int i = 0; i < plays.length; i++) {
			if(plays[i] == null) {
				break;
			}
			currentAttempts++;
		}
		
		return currentAttempts;
	}
}
