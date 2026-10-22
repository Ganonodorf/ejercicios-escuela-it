package masterMindModelViewController.views;

import masterMindModelViewController.utils.Observer;

public class RedoChoice extends Choice {
	
	public RedoChoice(Observer observer) {
		super(observer);
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setName() {
		this.name = "Redo proposal";
	}
}
