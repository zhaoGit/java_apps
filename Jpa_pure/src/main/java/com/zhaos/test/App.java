package com.zhaos.test;

import com.zhaos.service.IPersonService;
import com.zhaos.service.PersonServiceImpl;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPersonService personService = new PersonServiceImpl();
		personService.createPerson("Lily and lucy");
	}
}
