package com.zhaos.observer1;

import java.util.ArrayList;
import java.util.List;

public abstract class MySubject {
	protected List<Observer> observerList = new ArrayList<Observer>();
	
	public void attach(Observer observer){
		observerList.add(observer);
	}

	public void detach(Observer observer){
		observerList.remove(observer);
	}
	
	public abstract void cry();
}
