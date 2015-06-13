package com.zhaos.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhaos.domain.Person;
import com.zhaos.service.IPersonService;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AbstractApplicationContext beanFactory = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		IPersonService personService = (IPersonService) beanFactory
				.getBean("personServiceImpl");
		Person tmPerson = personService.createPerson("Jucy");
		Person person = personService.findOnePerson(tmPerson.getId());
		System.out.println("============================");
		System.out.println(person.getUser().getAddress());
		beanFactory.close();
	}
}
