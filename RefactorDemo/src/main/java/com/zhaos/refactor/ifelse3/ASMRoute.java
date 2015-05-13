package com.zhaos.refactor.ifelse3;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ASMRoute implements Route{
	
	@Autowired
	private DocRoute docRoute;
	
	private static Map<ChangeType, Performer> changeTypeMap = new HashMap<ChangeType, Performer>();

	@PostConstruct
	public void register(){
		docRoute.register(DocType.ASM, this);
	}
	
	
	@Override
	public Performer getPerformer(ChangeType changeType) {
		return ASMRoute.changeTypeMap.get(changeType);
	}
	
	@Override
	public void register(ChangeType changeType, Performer performer){
		ASMRoute.changeTypeMap.put(changeType, performer);
	}
}
