package com.zhaos.router;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EventGeneratorForAircore extends EventGeneratorBase{
	@Override
	public List<Event> buildEventList(String messageStr){
		System.out.println(MessageType.FLT + " " + EventParas.DATE_PATTERN + " aircore");
		return null;
	}

	@Override
	protected void initialParas() {
		EventParas.DATE_PATTERN = "MM/dd/yyyy";
	}

	@Override
	protected void registerGenerator() {
		EventGeneratorFactory.registerEventGenerator(MessageType.FLT, this);
	}
}
