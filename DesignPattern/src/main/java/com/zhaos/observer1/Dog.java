package com.zhaos.observer1;

public class Dog implements Observer {

	@Override
	public void response() {
		System.out.println("the dog is barking...");
	}

}
