package EnumInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("EnumInjection/applicationContext.xml");
		PersonService personService = applicationContext.getBean("personService", PersonService.class);
		personService.foo();
	}

}
