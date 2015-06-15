package com.zhaos.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zhaos.domain.Person;

@Repository
public class PersonDAOImpl{

	/*
	 * hibernate��ʽ�ı��棬SpringΪ�˷��㣬��һЩ���г־û������������
	 * �˹���
	 */
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Person savePerson(Person p) {
		 em.persist(p);
		 
		 return p;
	}
}
