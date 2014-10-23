package com.zhaos.refactor.ifelse2;


public class TIMPerformer extends Performer{
	
	
	@Override
	public void perform(Event event) {
		if(ChangeType.getChangeType(event.getChangeType()).equals(ChangeType.TIM)){
			excute(event);
			return;
		}
		super.perform(event);
	}

	@Override
	public void excute(Event event){
		System.out.println("TIM excute succesfully");
	}
}
