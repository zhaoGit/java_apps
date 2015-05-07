package com.zhaos.router1;

import java.util.Collections;
import java.util.List;


public class EventGeneratorForAircore extends EventGeneratorBase{
	@Override
	public List<Event> buildEventList(String messageStr, EventParas paras){
		System.out.println(MessageType.FLT + " " + paras.getDatePattern() + " aircore");
		return Collections.emptyList();
	}

	@Override
	protected EventParas configParas() {
		return new EventParas("MM/dd/yyyy");
	}
	
	private static class Factory extends EventGeneratorFactory{
		@Override
		public EventGeneratorBase createEventGenerator() {
			return new EventGeneratorForAircore();
		}
	}
	
	static{
		EventGeneratorFactoryHolder.registerEventGenerator(MessageType.FLT, new Factory());
	}
}
