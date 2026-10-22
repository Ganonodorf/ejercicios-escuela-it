package masterMindModelViewController.utils;

import java.util.ArrayList;

public class Observed {
	
	public ArrayList<Observer> observers;
	
	public Observed() {
		observers = new ArrayList<Observer>();
	}
	
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}
	
	public void notify(Event event) {
		for(Observer observer : observers) {
			observer.Update(event);
		}
	}
}
