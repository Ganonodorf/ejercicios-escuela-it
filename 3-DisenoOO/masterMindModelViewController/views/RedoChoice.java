package masterMindModelViewController.views;

import masterMindModelViewController.utils.Event;
import masterMindModelViewController.utils.Observer;

public class RedoChoice extends Choice {
	
	public RedoChoice(Observer observer) {
		super(observer);
	}

	@Override
	public void action() {
		this.notify(Event.Redo);
	}

	@Override
	public void setName() {
		this.name = "Redo proposal";
	}
}
