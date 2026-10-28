package masterMindModelViewController.views;

import masterMindModelViewController.models.MasterMind;
import masterMindModelViewController.utils.Observed;
import masterMindModelViewController.utils.Observer;

public abstract class Choice extends Observed{
	
	protected String name;
	
	protected MasterMind masterMind;
	
	public Choice(MasterMind masterMind, Observer observer) {
		this.setName();
		this.masterMind = masterMind; 
		this.addObserver(observer);
	}
	
	public abstract void action();
	
	public abstract void setName();
	
	public abstract boolean isActive();
	
	public String getName() {
		return this.name;
	}
}
