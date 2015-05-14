package com.zhaos.refactor.ifelse5;

import org.springframework.stereotype.Service;

@Service
public class SSMEQTHandler extends EventHandler{
	

	@Override
	public void handle(Event event){
		System.out.println("TIM excute succesfully");
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		HandlerHolder.registerHandler(DocType.SSM, ChangeType.EQT, this);
	}
}
