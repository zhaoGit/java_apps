package com.zhaos.router;

import java.util.List;

import javax.annotation.PostConstruct;

public abstract class EventGeneratorBase implements EventGenerator{

	@Override
	public List<Event> buildEventList(FlightMessage flightMessage) {
		EventParas paras = configParas();
		return buildEventList(flightMessage.getMsg(), paras);
	}
	
	protected abstract List<Event> buildEventList(String messageStr, EventParas paras);
	
	protected abstract EventParas configParas();
	
	@PostConstruct
	protected abstract void registerGenerator();
}
