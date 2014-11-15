package com.zhaos.observer3;

import java.util.EventObject;

public abstract class BaseEvent extends EventObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BaseEvent(Object source) {
		super(source);
	}
	public abstract void accept(PointListener pointListener);
}
