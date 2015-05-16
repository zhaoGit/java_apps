package com.zhaos.refactor.ifelse4;

import org.springframework.stereotype.Service;

@Service
public class ASMCNLFactory extends AbstractFactory{
	@Override
	public Availability createAvailability(){
		return new ASMCNLAvailability();
	}
	@Override
	public SegmentFilter createFilter(){
		return new ASMCNLSegmentFilter();
	}
	@Override
	protected void initial() {
		FactoryHolder.registerFactory(DocType.ASM, ChangeType.CNL, this);
	}
}
