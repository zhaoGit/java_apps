package com.zhaos.refactor.ifelse5;

import org.springframework.stereotype.Service;

@Service
public class SSMCNLHandler extends EventHandler{

	@Override
	public void handle(Event event){
		System.out.println("SSM CNL excute succesfully");
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		PerformerHolder.registerPerformer(DocType.SSM, ChangeType.CNL, this);
	}
}
