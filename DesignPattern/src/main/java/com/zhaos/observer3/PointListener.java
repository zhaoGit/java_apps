package com.zhaos.observer3;

import java.util.EventListener;

public interface PointListener extends EventListener{
	void onEvent(MoveEvent e);
	void onEvent(FocusEvent e);
}
