package com.zhaos.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhaos.domain.Address;
import com.zhaos.domain.ClassEntity;
import com.zhaos.domain.IdentityCard;
import com.zhaos.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DemoTest {

	@Autowired
	private IPersonService personService;

	@Test
	public void test() {
		Person person = new Person();
		ClassEntity classEntity = new ClassEntity();
		
		classEntity.setName("NO.1");
		classEntity.getPersonList().add(person);
		
		Address address = new Address();
		address.setState("USA");
		address.setCity("York");
		
		IdentityCard identityCard = new IdentityCard();
		identityCard.setNumber("411421198811111234");
		identityCard.setTimeout(10);
		identityCard.setPerson(person);
		
		person.setName("aaa");
		person.setClassEntity(classEntity);
		person.setAddress(address);
		person.setIdentityCard(identityCard);
		
//		assertNotNull(personService.saveClassEntity(classEntity));
		assertNotNull(personService.savePerson(person));
	}
}
