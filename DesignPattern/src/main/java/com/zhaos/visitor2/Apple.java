package com.zhaos.visitor2;

public class Apple implements Product{
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
