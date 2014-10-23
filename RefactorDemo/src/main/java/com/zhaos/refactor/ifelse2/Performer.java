package com.zhaos.refactor.ifelse2;

	
public abstract class Performer {
	private Performer performer;
	
	public void perform(Event event) {
		if(performer != null){
			performer.excute(event);
		}
	}
	
	protected abstract void excute(Event event);

	public Performer getPerformer() {
		return performer;
	}

	public void setPerformer(Performer performer) {
		this.performer = performer;
	}
}
