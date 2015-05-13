package com.zhaos.refactor.ifelse4;

import org.springframework.stereotype.Service;

@Service
public class TIMPerformer extends Performer{
	

	@Override
	public void excute(Event event){
		System.out.println("TIM excute succesfully");
	}
}
