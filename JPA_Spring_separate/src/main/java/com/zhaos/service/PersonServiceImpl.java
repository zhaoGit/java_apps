package com.zhaos.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhaos.dao.IPersonDAO;
import com.zhaos.domain.Person;
import com.zhaos.domain.User;
import com.zhaos.utilities.IDGenerator;

@Service("personServiceImpl")
public class PersonServiceImpl implements IPersonService {

	@Autowired
	@Qualifier("personDAO")
	private IPersonDAO personDAO;
	
	@Override
	@Transactional
	public Person createPerson(String name, String address) {
		Person p = new Person();
		p.setId(IDGenerator.getUUID());
		p.setName(name);
		p.setAddTime(new Date());
		User user = new User();
		user.setAddress(address);
		p.setUser(user);
		return personDAO.savePerson(p);
	}
	
	@Override
	public Person findOnePerson(String id){
	    return personDAO.findOnePerson(id);
	    
	    
	}

}
