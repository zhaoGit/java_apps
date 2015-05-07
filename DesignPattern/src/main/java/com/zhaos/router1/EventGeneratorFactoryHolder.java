package com.zhaos.router1;

import java.util.HashMap;
import java.util.Map;

public final class EventGeneratorFactoryHolder {
	//用于存放类型报文类型和EventGenerator的工厂之间的映射关系
	private static Map<MessageType, EventGeneratorFactory> generatorFactoryHolder = new HashMap<>();
	
	public static EventGeneratorFactory getEventGenerator(MessageType messageType){
		return generatorFactoryHolder.get(messageType);
	}
	
	public static void registerEventGenerator(MessageType messageType, EventGeneratorFactory eventGeneratorFactory){
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
