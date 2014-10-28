package com.zhaos.visitor2;


public abstract class Visitor {

	protected String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void visit(Apple apple);
	public abstract void visit(Book book);
}
