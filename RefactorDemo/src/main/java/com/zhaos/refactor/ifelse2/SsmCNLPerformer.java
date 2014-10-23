package com.zhaos.refactor.ifelse2;


public class SsmCNLPerformer extends Performer{
	

	@Override
	public void perform(Event event) {
		if(ChangeType.getChangeType(event.getChangeType()).equals(ChangeType.CNL) && !event.isAsm()){
			excute(event);
			return;
		}
		super.perform(event);
	}

	@Override
	public void excute(Event event){
		System.out.println("SSM CNL excute succesfully");
	}
}
