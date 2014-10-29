package com.zhaos.observer1;

public class Cat extends MySubject {

	@Override
	public void cry() {
		System.out.println("the cat is miaowing...");
		for (Observer observer : observerList) {
			observer.response();
		}
	}

}
