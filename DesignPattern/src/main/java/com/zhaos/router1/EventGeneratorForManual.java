package com.zhaos.router1;

import java.util.Collections;
import java.util.List;

public class EventGeneratorForManual extends EventGeneratorBase{

	@Override
	public List<Event> buildEventList(String messageStr, EventParas paras) {
		System.out.println(MessageType.GUI +" " + paras.getDatePattern() + " GUI");
		return Collections.emptyList();
	}

	@Override
	protected EventParas configParas() {
		return new EventParas("yyyy-MM-dd");
	}

	private static class Factory extends EventGeneratorFactory{
		@Override
		public EventGeneratorBase createEventGenerator() {
			return new EventGeneratorForManual();
		}
	}
	
	static{
		EventGeneratorHolder.registerEventGenerator(MessageType.GUI, new Factory().createEventGenerator());
	}
}
