package com.zhaos.refactor.ifelse1;

public enum ChangeType {

	CNL{
		@Override
		public void perform(Event event){
			if(event.isAsm()){
				CNL_ASM.perform(event);
				return;
			} 
			
			CNL_SSM.perform(event);
		}
	},	
	EQT,
	CNL_SSM,
	CNL_ASM,
	TIM;
	
	public void perform(Event event){
		PerformerHolder.getPerformer(this).excute(event);
	}
	
	public static ChangeType getChangeType(String changeTypeStr){
		return ChangeType.valueOf(changeTypeStr);
	}
}
