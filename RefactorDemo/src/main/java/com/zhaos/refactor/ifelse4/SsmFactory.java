package com.zhaos.refactor.ifelse4;

public class SsmFactory  implements FactoryByDocType{
	public Performer create(CnlChanger changeType){
		return new SsmCNLPerformer();
	}

	public Performer create(EqtChanger eqtChanger) {
		// TODO Auto-generated method stub
		return new SsmEqtPerformer();
	}
}
