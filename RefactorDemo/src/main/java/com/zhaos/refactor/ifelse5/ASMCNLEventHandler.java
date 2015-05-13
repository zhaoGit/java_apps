package com.zhaos.refactor.ifelse5;

import org.springframework.stereotype.Service;

@Service
public class ASMCNLEventHandler extends EventHandler{
	
	@Override
	public void handle(Event event){
		System.out.println("ASM CNL excute succesfully");
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		PerformerHolder.registerPerformer(DocType.ASM, ChangeType.CNL, this);
	}
}
