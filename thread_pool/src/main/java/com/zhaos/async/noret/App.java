package com.zhaos.async.noret;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 使用Spring的Async，省去了创建线程池，执行任务的过程，就像调用普通方法一样，
 * 对调用方透明，易于使用，只需打上一个标签即可。
 * 异步方法没有返回值。
 */
public class App {

	public static void main(String[] args) {
		ApplicationContext aContext = new ClassPathXmlApplicationContext("com/zhaos/async/noret/applicationContext.xml");
		IGreeting greeting = aContext.getBean("greeting", IGreeting.class);
		greeting.sayHello();
		System.out.println("end");
		((AbstractApplicationContext) aContext).close();
	}

}
