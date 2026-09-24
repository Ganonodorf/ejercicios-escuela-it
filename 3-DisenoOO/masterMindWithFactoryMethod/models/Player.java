package masterMindWithFactoryMethod.models;

public class Player {
	
	Combination combination;
	
	public Player() {
		
	}
	
	public void setCombination(Combination combination) {
		this.combination = combination;
	}
	
	public Combination getCombination() {
		return this.combination;
	}
}
