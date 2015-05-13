package com.zhaos.refactor.ifelse3;

public enum ChangeType {

	CNL,	
	EQT,
	CNL_SSM,
	CNL_ASM,
	TIM;
	
	public static ChangeType getChangeType(String changeTypeStr){
		return ChangeType.valueOf(changeTypeStr);
	}
}
