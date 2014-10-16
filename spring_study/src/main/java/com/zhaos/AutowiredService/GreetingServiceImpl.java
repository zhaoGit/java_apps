package com.zhaos.AutowiredService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * GreetingServiceImpl必须被spring创建（管理），字段dao才能被注入；
 * 如果是自己创建的，例如IGreetingService greetingService = new GreetingServiceImpl();
 * dao是不能被注入的；
 */
@Service("greetingService")
public class GreetingServiceImpl implements IGreetingService {

	@Autowired
	private DAO dao;
	
	private String greeting = "good";

	public String getGreeting() {
		return greeting;
	}
	

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public void sayGreeting() {
		dao.sayHello();
		System.out.println(greeting);
	}

}
