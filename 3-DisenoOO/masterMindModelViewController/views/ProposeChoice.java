package masterMindModelViewController.views;

import masterMindModelViewController.utils.Event;
import masterMindModelViewController.utils.Observer;

public class ProposeChoice extends Choice {
	
	public ProposeChoice(Observer observer) {
		super(observer);
	}

	@Override
	public void action() {
		this.notify(Event.Propose);
	}

	@Override
	public void setName() {
		this.name = "Propose a combination";
	}
}
