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
		EventGeneratorFactory eventGenerator = EventGeneratorFactoryHolder.getEventGenerator(flightMessage.getMsgType());
		return eventGenerator.createEventGenerator().buildEventList(flightMessage);
	}
}
