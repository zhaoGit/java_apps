package com.zhaos.observer3;


public class ListenerA extends DefaultPointerListener {
	//Handler：事件处理函数
	@Override
	public void onEvent(MoveEvent e) {
		super.onEvent(e);
		System.out.println("listenerA "+ ((Point)e.getSource()).getX() + ", "+  ((Point)e.getSource()).getY());
	}

	//Handler：事件处理函数
	@Override
	public void onEvent(FocusEvent e) {
		super.onEvent(e);
		System.out.println("listenerA "+ ((Point)e.getSource()).getX() + ", "+  ((Point)e.getSource()).getY());
	}
}
