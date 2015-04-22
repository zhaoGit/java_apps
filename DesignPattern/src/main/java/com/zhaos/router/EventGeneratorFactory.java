package com.zhaos.router;

import java.util.HashMap;
import java.util.Map;

public class EventGeneratorFactory {
	private static Map<MessageType, EventGenerator> generatorHolderMap = new HashMap<>();
	
	public static EventGenerator getEventGenerator(MessageType messageType){
		return generatorHolderMap.get(messageType);
	}
	
	public static void registerEventGenerator(MessageType messageType, EventGenerator eventGenerator){
		generatorHolderMap.put(messageType, eventGenerator);
	}
			
}
