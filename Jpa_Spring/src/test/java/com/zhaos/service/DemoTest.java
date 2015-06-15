package com.zhaos.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhaos.domain.ClassEntity;
import com.zhaos.domain.Person;
import com.zhaos.utilities.IDGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DemoTest {

	@Autowired
	private IPersonService personService;

	@Test
	public void test() {
		Person person = new Person();
		ClassEntity classEntity = new ClassEntity();

		person.setId(IDGenerator.getUUID());
		person.setName("aaa");
		person.setClassEntity(classEntity);
		
		classEntity.setGroupId(IDGenerator.getUUID());
		classEntity.setName("num 1");
		classEntity.getPersonList().add(person);
		
		assertNotNull(personService.saveClassEntity(classEntity));
	}

}
