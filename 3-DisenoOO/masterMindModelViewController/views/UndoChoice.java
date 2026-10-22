package masterMindModelViewController.views;

import masterMindModelViewController.utils.Observer;

public class UndoChoice extends Choice {
	
	public UndoChoice(Observer observer) {
		super(observer);
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setName() {
		this.name = "Undo proposal";
	}
}
