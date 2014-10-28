package com.zhaos.visitor;

import java.applet.Applet;
import java.awt.print.Book;

public class Customer extends Visitor{

	@Override
	public void visit(Applet apple) {

		System.out.println("customer " + name + "select apples" );
	}

	@Override
	public void visit(Book book) {
		System.out.println("customer " + name + "select books" );
	}
}
