package com.zhaos.observer3;

public class MainProgram {
	public static void main(String[] args) {
		Point mp = new Point(3, 5);

		PointListener plistener1 = new ListenerA();
		PointListener pListener2 = new ListenerB();
		mp.addEventListener(plistener1);
		mp.addEventListener(pListener2);

		mp.fireFocusEvent();
		mp.fireMoveEvent(10, 20);
	}
}
