package com.zhaos.service;

import com.zhaos.domain.ClassEntity;
import com.zhaos.domain.Person;

public interface IPersonService {

	Person findPerson(String name);

	Person savePerson(Person person);
	
	ClassEntity saveClassEntity(ClassEntity classEntity);
}