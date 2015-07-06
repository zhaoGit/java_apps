package com.zhaos.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhaos.domain.Person;
import com.zhaos.service.IPersonService;

public class App {

	/**
	 * Spring和JPA分开单独配置，所有和数据库有关的操作都在persistence.xml中；
	 * EntityManager是由Spring创建，所有有关数据库的操作都由EntityManager负责。
	 * EntityManager的所有属性都在persistence.xml中配置
	 */
	public static void main(String[] args) {

		AbstractApplicationContext beanFactory = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		IPersonService personService = (IPersonService) beanFactory
				.getBean("personServiceImpl");
		Person tmPerson = personService.createPerson("Jucy", "xingtai Hebei");
		Person person = personService.findOnePerson(tmPerson.getId());
		System.out.println("============================");
		System.out.println(person.getUser().getAddress());
		beanFactory.close();
	}
}
