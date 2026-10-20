package masterMindModelViewController.views;

public abstract class Choice {
	
	String name;
	
	public Choice() {
		this.setName();
	}
	
	public abstract void action();
	
	public abstract void setName();
	
	public String getName() {
		return this.name;
	}
}
