package com.zhaos.refactor.ifelse4;


public class HandlerRoute {
	public Performer findOneHandler(Event event){
		return event.getDocType().findOneHandlerByChangeTypeType(ChangeType.valueOf(event.getChangeType()));
	}
}
