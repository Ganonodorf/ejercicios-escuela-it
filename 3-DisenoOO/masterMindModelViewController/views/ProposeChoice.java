package masterMindModelViewController.views;

import masterMindModelViewController.utils.Observer;

public class ProposeChoice extends Choice {
	
	public ProposeChoice(Observer observer) {
		super(observer);
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setName() {
		this.name = "Propose a combination";
	}
}
