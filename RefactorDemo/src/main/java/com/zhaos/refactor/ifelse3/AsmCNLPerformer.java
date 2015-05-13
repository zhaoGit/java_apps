package com.zhaos.refactor.ifelse3;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsmCNLPerformer extends Performer{
	@Autowired
	private ASMRoute route;
//	
//	public AsmCNLPerformer(){
//		super(ChangeType.CNL_ASM);
//	}
	@PostConstruct
	public void registerPerformer() {
		route.register(ChangeType.CNL, this);
	}
	@Override
	public void excute(Event event){
		System.out.println("ASM CNL excute succesfully");
	}
}
