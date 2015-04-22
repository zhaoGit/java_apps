package com.zhaos.innerclass2;

public class App {
	public static void main(String[] args) {
		TypeEnum typeEnum = TypeEnum.CIRCLE;
               Shape shape = ShapeFactory.createShape(typeEnum);
               shape.draw();
               shape.erase();
	}
}
