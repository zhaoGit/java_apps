package com.zhaos.service;

import com.zhaos.domain.Person;

public interface IPersonService {

	Person createPerson(String name, String address);

    Person findOnePerson(String id);
}