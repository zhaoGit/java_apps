package com.zhaos.refactor.ifelse4;


public enum DocType {
	ASM {
		@Override
		protected FactoryByDocType getFacory() {
			return new AsmFactory();
		}
	}  ,
	SSM {
		@Override
		protected FactoryByDocType getFacory() {
			// TODO Auto-generated method stub
			return new SsmFactory();
		}
	} ;
	protected abstract FactoryByDocType getFacory();
	
	protected Performer  findOneHandlerByChangeTypeType(ChangeType changeType){
		return changeType.getChanger().accept(getFacory());
	}
}
