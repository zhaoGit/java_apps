package com.zhaos.visitor1;


public abstract class Visitor {

	protected String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void visit(Product product);
}
