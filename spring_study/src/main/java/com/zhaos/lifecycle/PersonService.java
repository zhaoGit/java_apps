package com.zhaos.lifecycle;

import org.springframework.beans.factory.BeanNameAware;

public class PersonService implements BeanNameAware{

	private String name;

	public PersonService(){
		System.out.println("constructor method run.");
	}
	public void sayHi(){
		System.out.println("hello " + name);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("set method run.");
		this.name = name;
	}
	@Override
	public void setBeanName(String arg0) {
		// TODO Auto-generated method stub
		System.out.println(arg0);
	}
}
