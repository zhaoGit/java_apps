package com.zhaos.refactor.ifelse3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimulatePlanGenerator {

	@Autowired
	private DocRoute docRoute;
	public void generate(Event event){
		//ChangeType.getChangeType(event.getChangeType()).perform(event);
		 docRoute.getPerformer(event).excute(event);
	}
}
