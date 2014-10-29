package com.zhaos.visitor1;


public class Saler extends Visitor{

	public void visit(Apple apple) {

		System.out.println("the saler" + name + "caculate apple price");
	}

	public void visit(Book book) {

		System.out.println("the saler" + name + "caculate book price");
	}

	@Override
	public void visit(Product product) {
		if(product instanceof Book){
			visit((Book)product);
		}else if(product instanceof Apple){
			visit((Book)product);
		}else{
			System.out.println("errro product");
		}
	}
}
