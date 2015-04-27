package com.zhaos.innerclass2;

import java.util.HashMap;
import java.util.Map;

public abstract class ShapeFactory {
	protected abstract Shape create();

	private static Map<TypeEnum, ShapeFactory> factories = new HashMap<TypeEnum, ShapeFactory>();
	static {
		try {
			Class.forName("com.zhaos.innerclass2.Circle");
			Class.forName("com.zhaos.innerclass2.Square");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void addFactory(TypeEnum type, ShapeFactory f) {
		factories.put(type, f);
	}

	public static final Shape createShape(TypeEnum typeEnum) {
		return factories.get(typeEnum).create();
	}
}