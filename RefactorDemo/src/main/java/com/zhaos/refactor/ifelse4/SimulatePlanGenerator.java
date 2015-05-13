package com.zhaos.refactor.ifelse4;



public class SimulatePlanGenerator {

	public void generate(Event event){
		new HandlerRoute().findOneHandler(event).excute(event);		
	}
}
