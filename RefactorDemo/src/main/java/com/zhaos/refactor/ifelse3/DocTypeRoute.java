package com.zhaos.refactor.ifelse3;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class DocTypeRoute implements DocRoute{
	private static Map<DocType, Route> docMap = new HashMap<DocType, Route>();

	@Override
	public void register(DocType docType, Route route){
		DocTypeRoute.docMap.put(docType, route);
	}
	@Override
	public Performer getPerformer(Event event){
		return DocTypeRoute.docMap.get(event.getDocType()).getPerformer(ChangeType.valueOf(event.getChangeType()));
	}
}
