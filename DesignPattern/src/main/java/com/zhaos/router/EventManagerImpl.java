package com.zhaos.router;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EventManagerImpl implements EventManager{
	@Override
	public List<Event> generateEventList(FlightMessage flightMessage){
		EventGenerator eventGenerator = EventGeneratorFactory.getEventGenerator(flightMessage.getMsgType());
		
		return eventGenerator.buildEventList(flightMessage);
	}
}
