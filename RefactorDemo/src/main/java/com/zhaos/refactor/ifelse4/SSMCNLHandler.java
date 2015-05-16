//package com.zhaos.refactor.ifelse4;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class SSMCNLHandler extends EventHandler {
//
//	@Override
//	public void handle(Event event){
//		Availability availability = new SSMCNLAvailability();
//		availability.acquire();
//		SegmentFilter segmentFilter = new SSMCNLSegmentFilter();
//		segmentFilter.filter();
//		System.out.println("SSM CNL excute succesfully");
//	}
//
//	@Override
//	protected void init() {
//		// TODO Auto-generated method stub
//		HandlerHolder.registerHandler(DocType.SSM, ChangeType.CNL, this);
//	}
//}
