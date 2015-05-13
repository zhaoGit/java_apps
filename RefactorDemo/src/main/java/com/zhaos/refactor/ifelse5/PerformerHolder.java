package com.zhaos.refactor.ifelse5;

import java.util.HashMap;
import java.util.Map;

public class PerformerHolder {

	private static Map<String, EventHandler> changeTypePerformerMap = new HashMap<String, EventHandler>();
	
	public static void registerPerformer(DocType docType, ChangeType changeType, EventHandler performer){
		changeTypePerformerMap.put(docType.name()+changeType.name(), performer);
	}
	
	public static EventHandler getPerformer(DocType docType, ChangeType changeType){
		return changeTypePerformerMap.get(docType.name() + changeType.name());
	}
}
