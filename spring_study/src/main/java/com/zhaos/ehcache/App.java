package com.zhaos.ehcache;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/zhaos/ehcache/applicationContext-cache.xml");
		MyService myService = ctx.getBean("myService", MyService.class);
		myService.saveData("aa", "bb");
		myService.saveData("cc", "dd");
		
		System.out.println(myService.getData("aa"));
		System.out.println(myService.getData("cc"));
		ctx.close();
	}

}
