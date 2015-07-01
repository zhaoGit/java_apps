package com.zhaos.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="zhaos_person")
public class Person extends MyEntity  {
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CLASS_ID")
	private ClassEntity classEntity;
	
	@Column(name="name",length=30,nullable=false) 
	private String name;
	
	@Column(name="addTime") 
	@Temporal(TemporalType.DATE)
	private Date addTime = new Date();
	
	/*
	 * The Embedded annotation is used to specify a persistent field or 
	 * property of an entity .Each of the persistent properties or fields
		of the embedded object is mapped to the database table for the entity 
		or embeddable class. The embeddable class must be annotated as 
		Embeddable
	 */
	@Embedded
	private Address address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}
	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
