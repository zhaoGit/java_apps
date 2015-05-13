package com.zhaos.refactor.ifelse3;

import org.springframework.stereotype.Service;

@Service
public class TIMPerformer extends Performer{
	
//	public TIMPerformer(){
//		super(ChangeType.TIM);
//	}
	
	@Override
	public void excute(Event event){
		System.out.println("TIM excute succesfully");
	}
}
