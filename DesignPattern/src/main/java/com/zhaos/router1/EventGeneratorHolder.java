package com.zhaos.router1;

import java.util.HashMap;
import java.util.Map;

public final class EventGeneratorHolder {
	//用于存放类型报文类型和EventGenerator的工厂之间的映射关系
	private static Map<MessageType, EventGeneratorBase> generatorFactoryHolder = new HashMap<>();
	
	public static EventGeneratorBase getEventGenerator(MessageType messageType){
		return generatorFactoryHolder.get(messageType);
	}
	
	public static void registerEventGenerator(MessageType messageType, EventGeneratorBase eventGeneratorFactory){
		generatorFactoryHolder.put(messageType, eventGeneratorFactory);
	}
	
	//当调用static方法getEventGenerator时，会执行此静态块
	static{
		try {
			Class.forName("com.zhaos.router1.EventGeneratorForAircore");
			Class.forName("com.zhaos.router1.EventGeneratorForManual");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
