package com.zhaos.applicationContextAware;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args){
		new ClassPathXmlApplicationContext("com/zhaos/applicationContextAware/applicationContext.xml");
		String str = "hello spring";
		SpringUtil.getLength(str);
	}
}
