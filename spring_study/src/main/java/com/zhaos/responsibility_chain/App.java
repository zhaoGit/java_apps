package com.zhaos.responsibility_chain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args){
		ApplicationContext aContext = new ClassPathXmlApplicationContext("com/zhaos/responsibility_chain/applicationContext.xml");
		Service service = aContext.getBean("service", Service.class);
		service.sayWords();
	}
}
	