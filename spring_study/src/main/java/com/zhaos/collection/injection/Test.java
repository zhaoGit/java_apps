package com.zhaos.collection.injection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/zhaos/collection/injection/applicationContext.xml");
		UserService us = (UserService) ctx.getBean("userservice");
		us.saveUser();
		ctx.close();
	}
}