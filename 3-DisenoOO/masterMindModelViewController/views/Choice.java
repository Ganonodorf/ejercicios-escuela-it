package masterMindModelViewController.views;

import masterMindModelViewController.utils.Observed;
import masterMindModelViewController.utils.Observer;

public abstract class Choice extends Observed{
	
	String name;
	
	public Choice(Observer observer) {
		this.setName();
		this.addObserver(observer);
	}
	
	public abstract void action();
	
	public abstract void setName();
	
	public String getName() {
		return this.name;
	}
}
