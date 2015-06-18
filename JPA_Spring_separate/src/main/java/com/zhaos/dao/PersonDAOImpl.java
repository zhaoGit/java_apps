package com.zhaos.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zhaos.domain.Person;

@Repository("personDAO")
public class PersonDAOImpl implements IPersonDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public Person savePerson(Person p) {
		 em.persist(p);
		 return p;
	}

	@Override
	public Person findOnePerson(String id){
	    return em.find(Person.class, id);
	}
}
