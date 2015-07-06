package com.zhaos.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zhaos.domain.Person;

@Repository("personDAO")
public class PersonDAOImpl implements IPersonDAO {
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
	 * 事务是由Spring进行管理的，EntityManager只负责增删改查
	 */
	@Override
	@Transactional
	public Person savePerson(Person p) {
		em.persist(p);
		return p;
	}

	@Override
	public Person findOnePerson(String id) {
		return em.find(Person.class, id);
	}
}
