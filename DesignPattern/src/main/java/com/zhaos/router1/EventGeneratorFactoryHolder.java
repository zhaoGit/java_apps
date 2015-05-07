package com.zhaos.router1;

import java.util.HashMap;
import java.util.Map;

public class EventGeneratorFactoryHolder {
	private static Map<MessageType, EventGeneratorFactory> generatorHolderMap = new HashMap<>();
	
	public static EventGeneratorFactory getEventGenerator(MessageType messageType){
		return generatorHolderMap.get(messageType);
	}
	
	public static void registerEventGenerator(MessageType messageType, EventGeneratorFactory eventGenerator){
		generatorHolderMap.put(messageType, eventGenerator);
	}
	
	static{
		try {
			Class.forName("com.zhaos.router1.EventGeneratorForAircore");
			Class.forName("com.zhaos.router1.EventGeneratorForManual");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
