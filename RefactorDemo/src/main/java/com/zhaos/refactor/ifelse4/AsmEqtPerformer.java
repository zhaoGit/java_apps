package com.zhaos.refactor.ifelse4;

import org.springframework.stereotype.Service;

@Service
public class AsmEqtPerformer extends Performer{
	
	@Override
	public void excute(Event event){
		System.out.println("EQT excute succesfully");
	}
}
