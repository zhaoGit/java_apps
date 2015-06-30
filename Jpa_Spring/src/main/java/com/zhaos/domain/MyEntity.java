package com.zhaos.domain;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.zhaos.utilities.IDGenerator;
/*@MappedSuperclass:The MappedSuperclassannotation designates a class 
whose mapping information is applied to the
entities that inherit from it. A mapped superclass has 
no separate table defined for it. */
@MappedSuperclass
public class MyEntity {
	@Id
	private String id;
	
	public MyEntity(){
		this.id = IDGenerator.getUUID();
	}
	
	public String getId() {
		return id;
	}
}
