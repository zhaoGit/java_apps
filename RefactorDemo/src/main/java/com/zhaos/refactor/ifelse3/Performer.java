package com.zhaos.refactor.ifelse3;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class Performer {
	
//	private ChangeType changeType;
//	
//	public Performer(ChangeType changeType){
//		this.changeType = changeType;
//	}
	
	public abstract void excute(Event event);
}
