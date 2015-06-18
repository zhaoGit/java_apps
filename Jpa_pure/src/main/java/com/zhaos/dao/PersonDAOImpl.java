package com.zhaos.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.zhaos.domain.Person;

public class PersonDAOImpl implements IPersonDAO {

	@Override
	public Person savePerson(Person p) {
		/*
		 * Notice that it is required to get an instance of EntityManagerFactory first 
		 * which will be linked to a Persistence Unit created in the persistence.xml file.
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("leanJPA");
		/*
		 * It is an interface. It manages the operations on objects. It works like a factory 
		 * for Query instance.
		 */
		EntityManager em = emf.createEntityManager();
		/*
		 * It has one-to-one relationship with the EntityManager. For each EntityManager,
		 * operations are maintained by the Entity Transaction class.
		 */
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		em.persist(p);
		et.commit();
		
		em.close();
		emf.close();
		
		return p;
	}
}
