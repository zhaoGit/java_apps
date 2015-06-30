package com.zhaos.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ZHAOS_CLASSENTITY")
public class ClassEntity extends MyEntity{

//	@Id
//	@Column(name="ClazzEnity_ID")
//	String classEntityId;
	
	@Column(name = "groupName")
	String name;

	@OneToMany(mappedBy="classEntity", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<Person> personList = new ArrayList<Person>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Person> getPersonList() {
		return personList;
	}
}
