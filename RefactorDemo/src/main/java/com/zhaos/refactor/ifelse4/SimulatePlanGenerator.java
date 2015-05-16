package com.zhaos.refactor.ifelse4;

import org.springframework.stereotype.Service;

@Service
public class SimulatePlanGenerator {

	public void generate(Event event){
		Factory factory = HandlerHolder.findOneCorrespondingHandlerWithCurrentEvent(event.getDocType(), ChangeType.valueOf(event.getChangeType()));
		Availability availability = factory.createAvailability();
		SegmentFilter segmentFilter = factory.createFilter();
		GeneratorController generatorController = new GeneratorController(availability, segmentFilter);
		generatorController.generate();
	}
}
