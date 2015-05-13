package com.zhaos.refactor.ifelse3;

public interface DocRoute {

	void register(DocType docType, Route route);

	Performer getPerformer(Event event);

}
