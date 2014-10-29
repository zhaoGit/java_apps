package com.zhaos.observer1;

public class Mouse implements Observer {

	@Override
	public void response() {
		System.out.println("the mouse is running...");
	}
}
