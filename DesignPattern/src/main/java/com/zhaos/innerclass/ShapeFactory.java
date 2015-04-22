package com.zhaos.innerclass;

import java.util.HashMap;
import java.util.Map;

public abstract class ShapeFactory {
	protected abstract Shape create();

	private static Map<String, ShapeFactory> factories = new HashMap<String, ShapeFactory>();

	public static void addFactory(String id, ShapeFactory f) {
		factories.put(id, f);
	}

	public static final Shape createShape(String id) {
		if (!factories.containsKey(id)) {
			try {
				Class.forName(id);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Bad shape creation : " + id);
			}
		}
		return factories.get(id).create();
	}
}