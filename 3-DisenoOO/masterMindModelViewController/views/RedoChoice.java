package masterMindModelViewController.views;

import masterMindModelViewController.models.MasterMind;
import masterMindModelViewController.utils.Event;
import masterMindModelViewController.utils.Observer;

public class RedoChoice extends Choice {
	
	public RedoChoice(MasterMind masterMind, Observer observer) {
		super(masterMind, observer);
	}

	@Override
	public void action() {
		this.notify(Event.Redo);
	}

	@Override
	public void setName() {
		this.name = "Redo proposal";
	}

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}
}
