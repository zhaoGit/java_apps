package com.zhaos.router;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EventGeneratorForAircore extends EventGeneratorBase{
	@Override
	public List<Event> buildEventList(String messageStr, EventParas paras){
		System.out.println(MessageType.FLT + " " + paras + " aircore");
		return Collections.emptyList();
	}

	@Override
	protected EventParas configParas() {
		return new EventParas("MM/dd/yyyy");
	}

	@Override
	protected void registerGenerator() {
		EventGeneratorFactory.registerEventGenerator(MessageType.FLT, this);
	}
}
