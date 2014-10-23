package com.zhaos.refactor.ifelse2;


public class AsmCNLPerformer extends Performer{
	

	@Override
	public void perform(Event event) {
		if(ChangeType.getChangeType(event.getChangeType()).equals(ChangeType.CNL)
				&& event.isAsm()){
			excute(event);
			return;
		}
		super.perform(event);
	}

	@Override
	protected void excute(Event event){
		System.out.println("ASM CNL excute succesfully");
	}
}
