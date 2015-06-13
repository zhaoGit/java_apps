package com.zhaos.service;

import com.zhaos.domain.Person;

public interface IPersonService {

	Person createPerson(String name);

    Person findOnePerson(String id);
}