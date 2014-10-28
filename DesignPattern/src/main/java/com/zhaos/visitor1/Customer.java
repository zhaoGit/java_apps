package com.zhaos.visitor1;


public class Customer extends Visitor{

	private void visit(Apple apple) {

		System.out.println("customer " + name + "select apples" );
	}

	private void visit(Book book) {
		System.out.println("customer " + name + "select books" );
	}

	@Override
	public void visit(Product product) {
		if(product instanceof Book){
			visit((Book)product);
		}else if(product instanceof Apple){
			visit((Apple)product);
		}else{
			System.out.println("errro product");
		}
	}
}
