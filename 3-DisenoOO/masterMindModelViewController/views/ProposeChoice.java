package masterMindModelViewController.views;

import masterMindModelViewController.models.MasterMind;
import masterMindModelViewController.utils.Event;
import masterMindModelViewController.utils.Observer;

public class ProposeChoice extends Choice {
	
	public ProposeChoice(MasterMind masterMind, Observer observer) {
		super(masterMind, observer);
	}

	@Override
	public void action() {
		this.notify(Event.Propose);
	}

	@Override
	public void setName() {
		this.name = "Propose a combination";
	}

	@Override
	public boolean isActive() {
		return true;
	}
}
