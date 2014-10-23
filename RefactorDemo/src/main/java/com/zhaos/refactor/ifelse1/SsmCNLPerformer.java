package com.zhaos.refactor.ifelse1;

import org.springframework.stereotype.Service;

@Service
public class SsmCNLPerformer extends Performer{
	
	public SsmCNLPerformer(){
		super(ChangeType.CNL_SSM);
	}

	@Override
	public void excute(Event event){
		System.out.println("SSM CNL excute succesfully");
	}
}
