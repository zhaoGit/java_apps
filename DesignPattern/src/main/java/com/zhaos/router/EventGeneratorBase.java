package com.zhaos.router;

import java.util.List;

import javax.annotation.PostConstruct;

public abstract class EventGeneratorBase implements EventGenerator{

	@Override
	public List<Event> buildEventList(FlightMessage flightMessage) {
		initialParas();
		return buildEventList(flightMessage.getMsg());
	}
	
	protected abstract List<Event> buildEventList(String messageStr);
	
	protected abstract void initialParas();
	
	@PostConstruct
	protected abstract void registerGenerator();
}
