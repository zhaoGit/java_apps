package com.zhaos.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="zhaos_person")
public class Person extends MyEntity  {
	
//	@Id 
//	@Column(name="id")
////	@GeneratedValue(generator = "paymentableGenerator")
////	@GenericGenerator(name = "paymentableGenerator", strategy = "assigned")
////	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="my_entity_seq_gen")
////	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="PERSONSEQ",allocationSize=1)
//	private String id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private ClassEntity classEntity;
	
	@Column(name="name",length=30,nullable=false) 
	private String name;
	
	@Column(name="addTime") 
	@Temporal(TemporalType.DATE)
	private Date addTime;
	
	@Column(name="flag") 
	private int flag;
	
	@Column(name="opcode")
	private String opcode;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the addDate
	 */
	public Date getAddTime() {
		return addTime;
	}
	/**
	 * @param addDate the addDate to set
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * @return the flag
	 */
	public int getFlag() {
		return flag;
	}
	/**
	 * @param flag the flag to set
	 */
	public void setFlag(int flag) {
		this.flag = flag;
	}
	/**
	 * @return the opcode
	 */
	public String getOpcode() {
		return opcode;
	}
	/**
	 * @param opcode the opcode to set
	 */
	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}

	public ClassEntity getClassEntity() {
		return classEntity;
	}
	public void setClassEntity(ClassEntity classEntity) {
		this.classEntity = classEntity;
	}
	
	
}
