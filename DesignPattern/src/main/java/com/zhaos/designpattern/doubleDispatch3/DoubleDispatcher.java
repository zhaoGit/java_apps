package com.zhaos.designpattern.doubleDispatch3;

/*
 * 动态类型绑定只会体现在方法的调用者身上，而方法的参数类型则会在编译期由编译器决定。如果参数类型也能
 * 够在运行期决定，那么哪个method被调用就由方法调用者和方法参数共同在运行期决定了。
 * 那么如何实现参数类型在运行期绑定呢？既然方法调用者的类型是运行期才确定的，那么我们就可以反客为主了，
 * 将方法参数变成方法调用者。
 */
class Father {
	public void accept(Execute exe) {
		exe.method(this);
	}
}

class Son1 extends Father {
	public void accept(Execute exe) {
		exe.method(this);
	}
}

class Son2 extends Father {
	public void accept(Execute exe) {
		exe.method(this);
	}
}

class Execute {
	public void method(Father father) {
		System.out.println("This is Father's method");
	}

	public void method(Son1 son) {
		System.out.println("This is Son1's method");
	}

	public void method(Son2 son) {
		System.out.println("This is Son2's method");
	}
}

public class DoubleDispatcher {
	public static void main(String[] args) {
		Father father = new Father();
		Father s1 = new Son1();
		Father s2 = new Son2();

		Execute exe = new Execute();
		/*
		 * s1调用accept是第一次分派，会分派到Son1的accept方法；第二次分派是重载，会调用method(Son1)方法
		 */
		father.accept(exe);
		s1.accept(exe);
		s2.accept(exe);
	}
}
