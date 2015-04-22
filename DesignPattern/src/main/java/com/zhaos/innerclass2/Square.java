package com.zhaos.innerclass2;

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
		ShapeFactory.addFactory(TypeEnum.SQUARE, new Factory());
	}

}