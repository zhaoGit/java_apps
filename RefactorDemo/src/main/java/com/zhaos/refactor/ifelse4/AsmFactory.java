package com.zhaos.refactor.ifelse4;
class AsmFactory implements FactoryByDocType{
	@Override
	public Performer create(CnlChanger changeType){
		return new AsmCNLPerformer();
	}
	@Override
	public Performer create(EqtChanger eqtChanger) {
		return new AsmEqtPerformer();
	}
}