package masterMindWithViews;

public class Play {
	
	private Combination combination;
	private Result result;
	
	public Play(Combination combination, Result result) {
		this.combination = combination;
		this.result = result;
	}
	
	public String toString() {
		return combination.toString() + " --> " + result.toString();
	}
}
