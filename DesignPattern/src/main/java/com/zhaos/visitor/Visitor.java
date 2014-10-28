package com.zhaos.visitor;

import java.applet.Applet;
import java.awt.print.Book;

public abstract class Visitor {

	protected String name;
	
	public abstract void visit(Applet apple);
	
	public abstract void visit(Book book);
}
