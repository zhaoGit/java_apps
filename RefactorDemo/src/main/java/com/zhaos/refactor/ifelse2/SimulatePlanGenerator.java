package com.zhaos.refactor.ifelse2;


public class SimulatePlanGenerator {

	private Performer performer;
	public void generate(Event event){
		performer.perform(event);
	}
	public Performer getPerformer() {
		return performer;
	}
	public void setPerformer(Performer performer) {
		this.performer = performer;
	}
}
