package com.zhaos.refactor.ifelse1;

import org.springframework.stereotype.Service;

@Service
public class SimulatePlanGenerator {

	public void generate(Event event){
		ChangeType.getChangeType(event.getChangeType()).perform(event);
	}
}
