package com.zhaos.dao;

import org.springframework.data.repository.Repository;

import com.zhaos.domain.Person;

public interface PersonDAO extends Repository<Person,String>,PersonRepository{

	Person findById(String id);
}
