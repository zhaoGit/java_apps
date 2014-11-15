package com.zhaos.observer2;

import java.util.EventListener;

public interface PointListener extends EventListener{

	public void pointMove(PointEventObject e);

}
