package com.zhaos.visitor2;


public class Saler extends Visitor{

	public void visit(Apple apple) {

		System.out.println("the saler" + name + "caculate apple price");
	}

	public void visit(Book book) {

		System.out.println("the saler" + name + "caculate book price");
	}
}
