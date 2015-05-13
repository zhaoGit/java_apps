package com.zhaos.refactor.ifelse5;

import org.springframework.stereotype.Service;

@Service
public class SimulatePlanGenerator {

	public void generate(Event event){
		EventHandler handler = PerformerHolder.getPerformer(event.getDocType(), ChangeType.valueOf(event.getChangeType()));
		handler.handle(event);
	}
}
