package com.zhaos.refactor.ifelse4;

import org.springframework.stereotype.Service;

@Service
public class SsmCNLPerformer extends Performer{
	
	@Override
	public void excute(Event event){
		System.out.println("SSM CNL excute succesfully");
	}
}
