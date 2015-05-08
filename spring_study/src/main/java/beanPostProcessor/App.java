package beanPostProcessor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args){
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanPostProcessor/applicationContext.xml");
		GreetingService greetingService = applicationContext.getBean("greetingService", GreetingService.class);
		greetingService.sayHello();
		applicationContext.close();
	}
}
