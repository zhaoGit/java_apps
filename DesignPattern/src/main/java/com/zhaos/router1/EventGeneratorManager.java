package com.zhaos.router1;

import java.util.List;

public final class EventGeneratorManager implements EventGenerator{
	
	public static EventGenerator getEventGenerator(){
		return new EventGeneratorManager();
	}
	
	private EventGeneratorManager() {
	}
	
	@Override
	public List<Event> generateEventList(FlightMessage flightMessage){
		EventGeneratorBase eventGenerator = EventGeneratorHolder.getEventGenerator(flightMessage.getMsgType());
		return eventGenerator.buildEventList(flightMessage);
	}
}
