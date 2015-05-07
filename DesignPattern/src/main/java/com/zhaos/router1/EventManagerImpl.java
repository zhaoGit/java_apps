package com.zhaos.router1;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EventManagerImpl implements EventManager{
	@Override
	public List<Event> generateEventList(FlightMessage flightMessage){
		EventGeneratorFactory eventGenerator = EventGeneratorFactoryHolder.getEventGenerator(flightMessage.getMsgType());
		return eventGenerator.create().buildEventList(flightMessage);
	}
}
