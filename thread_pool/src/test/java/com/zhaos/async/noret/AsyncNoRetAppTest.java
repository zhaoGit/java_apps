package com.zhaos.async.noret;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AsyncNoRetAppTest {

	/*
	 * 用普通的Java应用程序来测试多线程
	 */
	public static void main(String[] args) {
		ApplicationContext aContext = new ClassPathXmlApplicationContext(
				"com/zhaos/async/noret/applicationContext.xml");
		IGreeting greeting = aContext.getBean("greeting", IGreeting.class);
		greeting.sayHello();
		System.out.println("end");
		((AbstractApplicationContext) aContext).close();
	}
}
