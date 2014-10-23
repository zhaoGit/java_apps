package com.zhaos.refactor.ifelse1;

import javax.annotation.PostConstruct;

public abstract class Performer {
	private ChangeType changeType;
	
	public Performer(ChangeType changeType){
		this.changeType = changeType;
	}
	
	@PostConstruct
	public void init(){
		PerformerHolder.registerPerformer(changeType, this);
	}
	
	public abstract void excute(Event event);
}
