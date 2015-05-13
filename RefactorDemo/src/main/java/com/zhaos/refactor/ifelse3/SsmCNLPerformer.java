package com.zhaos.refactor.ifelse3;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SsmCNLPerformer extends Performer{
	@Autowired
	private SSMRoute route;
//	public SsmCNLPerformer(){
//		super(ChangeType.CNL);
//	}
	@PostConstruct
	public void registerPerformer(){
		route.register(ChangeType.CNL, this);
	}
	@Override
	public void excute(Event event){
		System.out.println("SSM CNL excute succesfully");
	}
}
