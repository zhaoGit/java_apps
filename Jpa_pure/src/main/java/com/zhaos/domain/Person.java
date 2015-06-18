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
	/**
	 * @return the jobtypeid
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param jobtypeid the jobtypeid to set
	 */
	public void setId(String id) {
		this.id = id;
	}
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
}
