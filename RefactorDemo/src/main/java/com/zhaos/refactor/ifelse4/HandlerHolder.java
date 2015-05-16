package com.zhaos.refactor.ifelse4;

import java.util.HashMap;
import java.util.Map;

public class HandlerHolder {

	private static Map<String, AbstractFactory> eventHandlerMap = new HashMap<String, AbstractFactory>();
	
	public static void registerHandler(DocType docType, ChangeType changeType, AbstractFactory performer){
		eventHandlerMap.put(docType.name()+changeType.name(), performer);
	}
	
	public static AbstractFactory findOneCorrespondingHandlerWithCurrentEvent(DocType docType, ChangeType changeType){
		return eventHandlerMap.get(docType.name() + changeType.name());
	}
}
