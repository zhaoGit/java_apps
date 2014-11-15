

package com.zhaos.observer3;

import java.util.*;
/*
 * 1、事件(event)：使一个类的对象的状态发生改变的动作就是一个事件。一个对象的状态就是封装在类中所有的数据集合，
 * 当这些数据中至少有一个发生改变我们就称该对象的状态发生了变化。更直白的说，也就是对象的成员变量的值发生了改变，
 * 我们就称为对象的状态发生了变化。
 * 如对于对象p：
 * 		p.setX(10);
 * 		p.setY(20);
 * 		p.moveTo(50,100);
 * 都改变了对象p原有的坐标，即位置状态发生了改变，所以设置方法和移动方法都会触发相应的事件。 
 * ************************************************************************************************************************
 * 2、事件名称：为了区别各个不同的事件，给不同的事件所起的名字称之为事件名称。
 * 		如上面的moveTo引起的事件，我们命名为moveEvent。setX引起的事件命名为setXEvent，setY引起的事件命名为setYEvent等等。
 * 当然可以用另外的名字。
 * ************************************************************************************************************************ 
 * 3、事件处理和事件处理方法：当某事件发生时，调用一个由用户指定的方法，完成用户需要完成的特定任务，这就是事件处理，这
 * 个方法也叫事件处理方法。
 * 		虽然对象p有很多事件，但是很多事件无需用户处理。如本文提出的问题，就不要求用户对setXEvent和setYEvent事件进行任何处理，
 * 虽然它们都改变了对象的状态。只要求对moveTo方法触发的移动事件moveEvent进行处理。所以要特别申明：我们所说的事件往往
 * 是指需要我们关注的那些事件，也就是实现了事件处理机制的那些事件。
 * ************************************************************************************************************************
 * 4、事件源(event source)：事件发生时，发生状态改变的对象称为事件源。如上面的p所引用的对象就是事件源，为了方便我们直接
 * 将p称为事件源。为了处理各种类型的事件，通常事件源的引用用Object类型：
 * 		Object source；
 * 这样对于上面的Point类来说，事件源就可以这样：
 * 		Object source = new Point(3,5);
 * 通过source能够访问它所引用的事件源的所有公有成员：
 * 		((Point)source).setX(10);
 * 		((Point)source).setY(20);
 * 		((Point)source).moveTo(10,20);
 * 或者：
 * 		Point sender =  ((Point)source)；
 * 		sender.setX(10);
 * 		sender.setY(20);
 * 		sender.moveTo(50,100);
 */

//3.事件源类
public class Point{

	private int x, y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public void fireMoveEvent(int x, int y)	{
		if (this.x != x || this.y != y)	{
			int x0 = this.x; // 保存移动前的坐标到x0、y0
			int y0 = this.y;

			this.x = x;
			this.y = y; // 修改对象的坐标x、y

			actionPerformed(new MoveEvent(this, x0, y0));
		}
	}


	public void fireFocusEvent()	{
		actionPerformed(new FocusEvent(this));
	}
	
	protected List<PointListener> list = Collections
			.synchronizedList(new ArrayList<PointListener>());

	public void addEventListener(PointListener pl) {
		list.add(pl);
	}

	public void removeEventListener(PointListener pl) {
		list.remove(pl);
	}

	protected  void  actionPerformed( BaseEvent  e ){
		if(list != null){
			Iterator<PointListener>  it =  list.iterator();
				while( it.hasNext()){
					PointListener  pl = it.next();
					e.accept(pl);
				}
			}
	}

	public String toString()	{	
		//以（x，y）的形式输出点的坐标	
		return String.format("(%1$d"," %2$d)",  x, y);
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}	
}
