package com.zhaos.refactor.ifelse3;

import org.springframework.stereotype.Service;

@Service
public class ASMEQTEventHandler extends EventHandler{
	
	@Override
	public void handle(Event event){
		System.out.println("ASM EQT excute succesfully");
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		HandlerHolder.registerHandler(DocType.ASM, ChangeType.EQT, this);
	}
}
