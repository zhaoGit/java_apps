package com.zhaos.router1;

import java.util.List;

//public abstract class EventGeneratorBase implements EventGenerator{
public abstract class EventGeneratorBase{

	public List<Event> buildEventList(FlightMessage flightMessage) {
		EventParas paras = configParas();
		return buildEventList(flightMessage.getMsg(), paras);
	}
	
	protected abstract List<Event> buildEventList(String messageStr, EventParas paras);
	
	protected abstract EventParas configParas();
}
