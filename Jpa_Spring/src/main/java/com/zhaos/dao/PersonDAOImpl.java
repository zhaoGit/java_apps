package com.zhaos.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zhaos.domain.Person;

@Repository
public class PersonDAOImpl{

	/*
	 * There are two ways to get an EntityManager. One is with injection and the
	 * other through a factory. The injection option will only work for JEE
	 * applications, running inside applications servers The EntityManager
	 * injection, until today, will work only with a server that supports an EJB
	 * container.
	 * 
	 * When the application is JSE(desktop) application or when a web
	 * application want to handle the database connection manually just use .
	 */
	@PersistenceContext
	private EntityManager em;
	
	/*
	 * The @Transactional annotation is simply metadata that 
	 * can be consumed by some runtime infrastructure that is  
	 * @Transactional-aware and that can use the metadata to 
	 * configure the appropriate beans with transactional behavior. 
	 *  the  <tx:annotation-driven/>element  switches on 
	 *  the transactional behavior.Use the <tx:annotation-driven/> 
	 *  element for processing of Spring's @Transactional.
	 */
	@Transactional
	public Person savePerson(Person p) {
		 em.persist(p);
		 
		 return p;
	}
}
