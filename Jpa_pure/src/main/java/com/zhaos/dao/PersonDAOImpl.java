package com.zhaos.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.zhaos.domain.Person;

public class PersonDAOImpl implements IPersonDAO {

	@Override
	public Person savePerson(Person p) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("leanJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		em.persist(p);
		et.commit();
		
		em.close();
		emf.close();
		
		return p;
	}

	
}
