//package com.zhaos.refactor.ifelse4;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class ASMCNLHandler extends EventHandler{
//	
//	@Override
//	public void handle(Event event){
//		Availability availability = new ASMCNLAvailability();
//		availability.acquire();
//		SegmentFilter segmentFilter = new ASMCNLSegmentFilter();
//		segmentFilter.filter();
//		System.out.println("ASM CNL excute succesfully");
//	}
//
//	@Override
//	protected void init() {
//		// TODO Auto-generated method stub
//		HandlerHolder.registerHandler(DocType.ASM, ChangeType.CNL, this);
//	}
//}
