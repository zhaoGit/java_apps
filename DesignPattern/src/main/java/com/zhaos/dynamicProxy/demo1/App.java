package com.zhaos.dynamicProxy.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface ISubject {
	void Request();
}

interface IAdvice{
	void preInvoke();
	void afterInvoke();
}

class ConcreteSubject implements ISubject {
	@Override
	public void Request() {
		System.out.println("ConcreteSubject:Request");
	}
}

class DynProxyManagerBase implements InvocationHandler{

	private ISubject subject;
	private IAdvice advice;
	
	public DynProxyManagerBase(ISubject subject, IAdvice advice){
		this.subject = subject;
		this.advice = advice;
	}
	
	//正如名字一样：invocation，handler，一旦有函数调用发生，则该处理方式会立即响应
	//动态代理类的实例的所有方法调用都会转为调用该方法
	//s.Request()执行时，s去初始化args0, s是jdk生成的动态代理类,
	//Request会被封装成Method，参数会初始化arg2
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		System.out.println(arg2);
		if(advice != null){
			advice.preInvoke();	
		}
		
		Object retObject = arg1.invoke(subject, (Object[])null);
		
		if(advice != null){
			advice.afterInvoke();
		}			
		return retObject;
	}
}

class Advice implements IAdvice{

	@Override
	public void preInvoke() {
		// TODO Auto-generated method stub
		System.out.println("before");
	}

	@Override
	public void afterInvoke() {
		// TODO Auto-generated method stub
		System.out.println("end");
	}
}


public class App {

	public static void main(String[] args) {

		ConcreteSubject subject = new ConcreteSubject();
		DynProxyManagerBase manager = new DynProxyManagerBase(subject, new Advice());
		
		ISubject s = (ISubject) Proxy.newProxyInstance(ISubject.class.getClassLoader(), new Class<?>[]{ISubject.class}, manager);

		s.Request();			
	}
}
