package com.zhaos.domain;

import javax.persistence.Embeddable;
/**
 * 这是一个值对象，要依赖于实体，作为实体的一部分存储到实体中
 * 
 * @author zhaosheng
 *
 */
@Embeddable
public class Address {
	private String state;
	private String city;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
