package com.zhaos.router;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EventGeneratorForManual extends EventGeneratorBase{

	@Override
	public List<Event> buildEventList(String messageStr, EventParas paras) {
		System.out.println(MessageType.GUI +" " + paras + " GUI");
		return Collections.emptyList();
	}

	@Override
	protected EventParas configParas() {
		return new EventParas("yyyy-MM-dd");
	}

	@Override
	protected void registerGenerator() {
		EventGeneratorFactory.registerEventGenerator(MessageType.GUI, this);
	}
}
