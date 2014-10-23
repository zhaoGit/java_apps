package com.zhaos.refactor.ifelse2;


public class EQTPerformer extends Performer {

	@Override
	public void perform(Event event) {
		if (ChangeType.getChangeType(event.getChangeType()) == ChangeType.EQT){
			excute(event);
			return;
		}
		super.perform(event);
	}

	@Override
	public void excute(Event event) {
		System.out.println("EQT excute succesfully");
	}
}
