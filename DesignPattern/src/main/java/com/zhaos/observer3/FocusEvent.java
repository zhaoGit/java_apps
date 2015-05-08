package com.zhaos.observer3;

/**
 * 事件对象
 * 
 * @author zhaosheng
 *
 */
public class FocusEvent extends BaseEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FocusEvent(Object arg0) {
		super(arg0);
	}

	@Override
	public void accept(PointListener pointListener) {
		pointListener.onEvent(this);
	}
}
