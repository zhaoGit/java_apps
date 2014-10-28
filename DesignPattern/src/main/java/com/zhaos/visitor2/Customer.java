package com.zhaos.visitor2;


public class Customer extends Visitor{

	@Override
	public void visit(Apple apple) {

		System.out.println("customer " + name + "select apples" );
	}

	@Override
	public void visit(Book book) {
		System.out.println("customer " + name + "select books" );
	}
}
