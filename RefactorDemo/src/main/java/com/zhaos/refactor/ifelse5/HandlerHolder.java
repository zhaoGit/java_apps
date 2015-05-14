package com.zhaos.refactor.ifelse5;

import java.util.HashMap;
import java.util.Map;

public class HandlerHolder {

	private static Map<String, EventHandler> eventHandlerMap = new HashMap<String, EventHandler>();
	
	public static void registerHandler(DocType docType, ChangeType changeType, EventHandler performer){
		eventHandlerMap.put(docType.name()+changeType.name(), performer);
	}
	
	public static EventHandler findOneCorrespondingHandlerWithCurrentEvent(DocType docType, ChangeType changeType){
		return eventHandlerMap.get(docType.name() + changeType.name());
	}
}
