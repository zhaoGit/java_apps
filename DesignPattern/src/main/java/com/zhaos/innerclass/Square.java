package com.zhaos.innerclass;

public class Square implements Shape {

	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("the square is drawing...");
	}

	public void erase() {
		// TODO Auto-generated method stub
		System.out.println("the square is erasing...");
	}

	private static class Factory extends ShapeFactory {
		protected Shape create() {
			return new Square();
		}
	}

	static {
		ShapeFactory.addFactory("com.zhaos.innerclass.Square", new Factory());
	}

}