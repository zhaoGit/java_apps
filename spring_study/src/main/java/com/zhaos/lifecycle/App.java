package com.zhaos.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	public static void main(String[] args){
		ApplicationContext aContext = new ClassPathXmlApplicationContext("com/zhaos/lifecycle/applicationContext.xml");
		PersonService personService =  aContext.getBean("personService", PersonService.class);
		personService.sayHi();
		((AbstractApplicationContext) aContext).close();
	}
}
	