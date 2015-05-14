package com.zhaos.refactor.ifelse3;

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
		HandlerHolder.registerHandler(DocType.SSM, ChangeType.CNL, this);
	}
}
