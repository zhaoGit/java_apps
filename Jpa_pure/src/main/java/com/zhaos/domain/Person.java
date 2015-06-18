package com.zhaos.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zhaos_person")
public class Person implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id 
	@Column(name="id")
//	@GeneratedValue(generator = "paymentableGenerator")
//	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="my_entity_seq_gen")
//	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="PERSONSEQ",allocationSize=1)
	private String id;
	
	@Column(name="name",length=30,nullable=false) 
	private String name;
	
	@Column(name="addTime") 
	private Date addTime;
	
	@Column(name="flag") 
	private int flag;
	
	@Column(name="opcode")
	private String opcode;
	
	public Person(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getOpcode() {
		return opcode;
	}

	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}
}
