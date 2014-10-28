package com.zhaos.visitor;

import java.applet.Applet;
import java.awt.print.Book;

public class Saler extends Visitor{

	@Override
	public void visit(Applet apple) {

		System.out.println("the saler" + name + "caculate apple price");
	}

	@Override
	public void visit(Book book) {

		System.out.println("the saler" + name + "caculate book price");
	}

}
