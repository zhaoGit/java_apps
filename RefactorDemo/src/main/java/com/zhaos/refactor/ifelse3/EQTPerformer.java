package com.zhaos.refactor.ifelse3;

import org.springframework.stereotype.Service;

@Service
public class EQTPerformer extends Performer{
	
//	public EQTPerformer(){
//		super(ChangeType.EQT);
//	}
	
	@Override
	public void excute(Event event){
		System.out.println("EQT excute succesfully");
	}
}
