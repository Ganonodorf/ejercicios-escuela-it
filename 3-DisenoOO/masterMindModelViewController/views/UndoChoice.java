package masterMindModelViewController.views;

import masterMindModelViewController.models.MasterMind;
import masterMindModelViewController.utils.Event;
import masterMindModelViewController.utils.Observer;

public class UndoChoice extends Choice {
	
	public UndoChoice(MasterMind masterMind, Observer observer) {
		super(masterMind, observer);
	}

	@Override
	public void action() {
		this.notify(Event.Undo);
	}

	@Override
	public void setName() {
		this.name = "Undo proposal";
	}

	@Override
	public boolean isActive() {
		return masterMind.canUndo();
	}
}
