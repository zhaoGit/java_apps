package com.zhaos.refactor.ifelse4;

import org.springframework.stereotype.Service;

@Service
public class SSMCNLFactory extends AbstractFactory{
	@Override
	public Availability createAvailability(){
		return new SSMCNLAvailability();
	}

	@Override
	public SegmentFilter createFilter(){
		return new SSMCNLSegmentFilter();
	}

	@Override
	protected void initial() {
		// TODO Auto-generated method stub
		FactoryHolder.registerFactory(DocType.SSM, ChangeType.CNL, this);
	}
}
