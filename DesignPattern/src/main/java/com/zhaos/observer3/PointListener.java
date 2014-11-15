package com.zhaos.observer3;

import java.util.EventListener;
import java.util.EventObject;

public interface PointListener extends EventListener{
	void onEvent(MoveEvent e);
	void onEvent(FocusEvent e);
}
