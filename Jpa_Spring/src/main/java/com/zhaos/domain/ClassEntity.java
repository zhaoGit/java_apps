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
	
	@Column(name = "groupName")
	String name;
	/*
	 * mappedBy指由Person的classEntity字段负责映射外键关系,如果是OneToOne的
	 * 映射，外键则会建在Person实体对应的表中。
	 */
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
