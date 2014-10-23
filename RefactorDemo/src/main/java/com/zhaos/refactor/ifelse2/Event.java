package com.zhaos.refactor.ifelse2;

public class Event {

	private String changeType;
	
	private boolean asm;



	public boolean isAsm() {
		return asm;
	}

	public void setAsm(boolean asm) {
		this.asm = asm;
	}

	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
}
