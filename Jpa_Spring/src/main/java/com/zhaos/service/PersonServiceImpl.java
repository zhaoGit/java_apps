package com.zhaos.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhaos.dao.ClassEntityDAO;
import com.zhaos.dao.PersonDAO;
import com.zhaos.domain.ClassEntity;
import com.zhaos.domain.Person;

@Service("personServiceImpl")
public class PersonServiceImpl implements IPersonService {

	@Autowired
	private PersonDAO personDAO;
	
	@Autowired
	private ClassEntityDAO classEntityDAO;
	
	@Override
	@Transactional
	public Person findPerson(String id) {
		return personDAO.findById(id);
	}

	@Override
	public Person savePerson(Person person){
		person.setAddTime(new Date());
		return personDAO.savePerson(person);
	}

	@Override
	public ClassEntity saveClassEntity(ClassEntity classEntity) {
		return classEntityDAO.save(classEntity);
	}
}
