package com.zhaos.test;

import com.zhaos.service.IPersonService;
import com.zhaos.service.PersonServiceImpl;

public class App {

	/**
	 * 这是一种纯粹的JPA Demo，Hibernate是实现者；没有集成Spring，Sping-data-jpa
	 */
	public static void main(String[] args) {
		IPersonService personService = new PersonServiceImpl();
		personService.createPerson("Lily and lucy");
	}
}
