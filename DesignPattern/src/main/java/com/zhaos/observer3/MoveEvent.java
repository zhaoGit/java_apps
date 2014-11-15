package com.zhaos.observer3;


/*
 *		 事件对象(event object )：事件源在事件发生时能够将事件发生前后的事件源的状态信息发送到事件处理
 * 方法中供事件处理方法使用。因此有时也将事件源称为事件状态信息的发送者（sender）。通常将这些信
 * 息封装在一个对象中，这个对象称为事件对象。
 * 		要特别注意区分事件源和事件对象。事件对象中包含事件源的引用，但还有其它反映事件源在发生事件
 * 前后的状态的信息。
 * 		对本文最前面提出的问题，即Point来说：
 * 事件对象类应该封装的数据包括：
 * 1、事件源的引用（source）：通过它可以访问事件源所有公有成员，并能够获得事件源的当前状态信息。
 * 2、反映事件源状态变化的数据：不能通过source获取而用户又关心的数据。如：moveEvent事件发生之
 * 前的坐标(x0,y0)。事件发生后的坐标可以通过source获得。然后通过公有的访问方法来获取它们，本例只
 * 要求能获得就行。
 */
public class MoveEvent extends BaseEvent{
	private static final long serialVersionUID = 1L;
	// 事件源引用及访问方法，在基类中已经定义，此处无需定义
	
	// 定义需要保存的参数及访问方法，这里是事件发生之前的坐标
	private int x0, y0; // 保存事件发生之前的坐标

	public int getX0() {
		return x0;
	}

	public int getY0() {
		return y0;
	}

	// 定义构造方法
	public MoveEvent(Object source, int x0, int y0)
	{
		super(source);
		this.x0 = x0;
		this.y0 = y0;
	}

	public void accept(PointListener pointListener){
		pointListener.onEvent(this);
	}
}
