package com.zhaos.router1;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
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
		public EventGeneratorBase create() {
			return new EventGeneratorForManual();
		}
	}
	
	static{
		EventGeneratorFactoryHolder.registerEventGenerator(MessageType.GUI, new Factory());
	}
}
