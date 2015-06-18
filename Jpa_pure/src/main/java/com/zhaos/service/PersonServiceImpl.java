package com.zhaos.service;

import java.util.Date;

import com.zhaos.dao.IPersonDAO;
import com.zhaos.dao.PersonDAOImpl;
import com.zhaos.domain.Person;
import com.zhaos.utilities.IDGenerator;

public class PersonServiceImpl implements IPersonService {

	private IPersonDAO personDAO = new PersonDAOImpl();
	
	@Override
	public Person createPerson(String name) {
		Person p = new Person();
		
		p.setId(IDGenerator.getUUID());
		p.setName(name);
		p.setAddTime(new Date());
		
		return personDAO.savePerson(p);
	}
}
