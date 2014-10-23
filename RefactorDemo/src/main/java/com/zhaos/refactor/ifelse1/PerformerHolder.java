package com.zhaos.refactor.ifelse1;

import java.util.HashMap;
import java.util.Map;

public class PerformerHolder {

	private static Map<ChangeType, Performer> changeTypePerformerMap = new HashMap<ChangeType, Performer>();
	
	public static void registerPerformer(ChangeType changeType, Performer performer){
		changeTypePerformerMap.put(changeType, performer);
	}
	
	public static Performer getPerformer(ChangeType changeType){
		return changeTypePerformerMap.get(changeType);
	}
}
