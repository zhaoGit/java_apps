package com.zhaos.refactor.ifelse4;

import java.util.HashMap;
import java.util.Map;

public class FactoryHolder {

	private static Map<String, AbstractFactory> docTypeChangeTypeToFactoryMap = new HashMap<String, AbstractFactory>();
	
	public static void registerFactory(DocType docType, ChangeType changeType, AbstractFactory factory){
		docTypeChangeTypeToFactoryMap.put(docType.name()+changeType.name(), factory);
	}
	
	public static AbstractFactory findOneCorrespondingFactory(DocType docType, ChangeType changeType){
		return docTypeChangeTypeToFactoryMap.get(docType.name() + changeType.name());
	}
}
