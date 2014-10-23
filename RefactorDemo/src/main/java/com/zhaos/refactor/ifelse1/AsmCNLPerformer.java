package com.zhaos.refactor.ifelse1;

import org.springframework.stereotype.Service;

@Service
public class AsmCNLPerformer extends Performer{
	
	public AsmCNLPerformer(){
		super(ChangeType.CNL_ASM);
	}

	@Override
	public void excute(Event event){
		System.out.println("ASM CNL excute succesfully");
	}
}
