package com.zhaos.router;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EventGeneratorForManual extends EventGeneratorBase{

	@Override
	public List<Event> buildEventList(String messageStr) {
		System.out.println(MessageType.GUI +" " +EventParas.DATE_PATTERN + " GUI");
		return null;
	}

	@Override
	protected void initialParas() {
		EventParas.DATE_PATTERN = "yyyy-MM-dd";
	}

	@Override
	protected void registerGenerator() {
		EventGeneratorFactory.registerEventGenerator(MessageType.GUI, this);
	}
}
