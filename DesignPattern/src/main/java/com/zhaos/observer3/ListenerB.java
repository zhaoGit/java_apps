package com.zhaos.observer3;


public class ListenerB extends DefaultPointerListener {

	@Override
	public void onEvent(MoveEvent e) {
		super.onEvent(e);
		System.out.println("listenerB "+ ((Point)e.getSource()).getX() + ", "+  ((Point)e.getSource()).getY());
	}
}
