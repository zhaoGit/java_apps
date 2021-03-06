package com.zhaos.refactor.ifelse3;

import javax.annotation.PostConstruct;

public abstract class EventHandler {
	@PostConstruct
	protected abstract void init();
	
	public abstract void handle(Event event);
}
