package com.zhaos.refactor.ifelse4;

public class CnlChanger extends Changer{
	@Override
	public Performer accept(AsmFactory factory){
		return factory.create(this);
	}

	@Override
	public Performer accept(SsmFactory ssmFactory) {
		// TODO Auto-generated method stub
		return ssmFactory.create(this);
	}
}
