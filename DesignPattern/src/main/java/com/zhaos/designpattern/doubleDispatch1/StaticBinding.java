package com.zhaos.designpattern.doubleDispatch1;

/*
 * 对于动态绑定，静态绑定就是指在编译期就已经确定执行哪一个方法。在java中，方法的重载（方法名相同而参数不同）
 * 就是静态绑定的，重载时，执行哪一个方法在编译期就已经确定下来了。看一下代码
 */
class Father {}
class Son1 extends Father{}
class Son2 extends Father{}

class Execute {
	public void method(Father father){
		System.out.println("This is Father's method");
	}
	
	public void method(Son1 son){
		System.out.println("This is Son1's method");
	}
	
	public void method(Son2 son){
		System.out.println("This is Son2's method");
	}
}

public class StaticBinding {
	public static void main(String[] args){
		Father father = new Father();
		Father s1 = new Son1();
		Father s2 = new Son2();

		Execute exe = new Execute();
		exe.method(father);
		//静态绑定，因为编译时按照s1是Father类型就确定了调用的方法
		exe.method(s1);
		//静态绑定
		exe.method(s2);
	}
}
