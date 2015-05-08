package com.zhaos.observer3;

/**
 * 该观察者只关注MoveEvent,因此只需实现MoveEvent对应的处理函数
 * 
 * @author zhaosheng
 *
 */
public class ListenerB extends DefaultPointerListener {

	@Override
	public void onEvent(MoveEvent e) {
		super.onEvent(e);
		System.out.println("listenerB "+ ((Point)e.getSource()).getX() + ", "+  ((Point)e.getSource()).getY());
	}
}
