package com.zhaos.observer1;

/*
 * 假定猫是老鼠和狗的观察目标，老鼠和狗是观察者，猫叫老鼠跑，狗也跟着叫。
 * 可以用观察者模式设计该场景。
 */
public class App {

	public static void main(String[] args) {
		MySubject subject = new Cat();
		
		Observer observer1 = new Mouse();
		Observer observer2 = new Dog();
		
		subject.attach(observer1);
		subject.attach(observer2);
		
		subject.cry();
	}
}
