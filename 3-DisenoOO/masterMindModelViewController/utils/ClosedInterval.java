package masterMindModelViewController.utils;

public class ClosedInterval {
	
	private int min;
	
	private int max;
	
	public ClosedInterval(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public boolean includes(int number) {
		return number >= min && number <= max;
	}
}
