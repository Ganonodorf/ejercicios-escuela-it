package masterMindModelViewController.views;

import masterMindModelViewController.utils.Event;
import masterMindModelViewController.utils.Observer;

public class UndoChoice extends Choice {
	
	public UndoChoice(Observer observer) {
		super(observer);
	}

	@Override
	public void action() {
		this.notify(Event.Undo);
	}

	@Override
	public void setName() {
		this.name = "Undo proposal";
	}
}
