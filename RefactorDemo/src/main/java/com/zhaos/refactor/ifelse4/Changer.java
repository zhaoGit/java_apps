package com.zhaos.refactor.ifelse4;


public abstract class Changer {

	public abstract Performer accept(AsmFactory factory);

	public  abstract Performer accept(SsmFactory ssmFactory) ;

	public Performer accept(FactoryByDocType facory) {
		// TODO Auto-generated method stub
		return null;
	}

}
