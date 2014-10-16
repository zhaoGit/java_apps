package beanPostProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanPostProcessor/applicationContext.xml");
		GreetingService greetingService = applicationContext.getBean("greetingService", GreetingService.class);
		greetingService.sayHello();
	}

}
