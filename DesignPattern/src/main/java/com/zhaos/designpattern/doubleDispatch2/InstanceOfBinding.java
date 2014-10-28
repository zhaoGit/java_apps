package com.zhaos.designpattern.doubleDispatch2;

/*
 * 请注意，我们必须把判断是否是父类的条件（也就是判断是否为Father类的条件）
 * 放到最后，否则将一律会被判断为Father类，达不到我们动态判断的目的。
 * 修改代码后，程序就可以动态地根据参数的实际类型来调用相应的方法了。
 * 但是这种实现方式有一个明显的缺点，它是伪动态的，仍然需要我们来通过程序
 * 来判断类型。假如Father有100个子类的话，还是这样来实现显然是不合适的。
 * 必须通过其他更好的方式实现才行，我们可以使用双分派方式来实现动态绑定
 * 
 */
class Father {}
class Son1 extends Father{}
class Son2 extends Father{}

class Execute {
	public void method(Father father){
		if(father instanceof Son1){
			method((Son1)father);
		}else if(father instanceof Son2){
			method((Son2)father);
		}else if(father instanceof Father){
			System.out.println("This is Father's method");
		}
	}
	
	private void method(Son1 son){
		System.out.println("This is Son1's method");
	}
	
	private void method(Son2 son){
		System.out.println("This is Son2's method");
	}
}

public class InstanceOfBinding {
	public static void main(String[] args){
		Father father = new Father();
		Father s1 = new Son1();
		Father s2 = new Son2();

		Execute exe = new Execute();
		exe.method(father);
		exe.method(s1);
		exe.method(s2);
	}
}
