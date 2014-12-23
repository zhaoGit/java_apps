package com.zhaos.segmentMatchFlight;

import java.util.List;

public class FlightMatchSegments {
	public static void validFlightMatchSegments(List<Leg> legList, List<Segment> segmentList) throws Exception {
	    if(segmentList==null || segmentList.isEmpty()){
	        return;
	    }
	    
	    for(Segment walk : segmentList){
	        validFlightMatchSegments(legList, walk);
	    }
	    
	}
	
	private static void validFlightMatchSegments(List<Leg> legList, Segment segment) throws Exception{
	    if(segment.getDeptAirport().equalsIgnoreCase(segment.getArrivalAirport())){
	        throw new Exception("起飞和到达机场一样，请修改~");
	    }
	    //在有序的航节链条中，depOk用于标示找到了起飞机场，arrOk用于标示找到了到达机场。
	    boolean depOk = false;
	    boolean arrOk = false;
	    for(int i=0; i<legList.size(); i++){
	        if (!depOk){
	            depOk = legList.get(i).getDeptAirport().equalsIgnoreCase(segment.getDeptAirport());
	        }
	        
	        if (!depOk){
	        	continue;
	        }
	        if(depOk && !arrOk){
	            arrOk = legList.get(i).getDeptAirport().equalsIgnoreCase(segment.getArrivalAirport());
	        }
	        
	        if(i == legList.size() -1 && depOk && !arrOk){
	            arrOk = legList.get(i).getArrivalAirport().equalsIgnoreCase(segment.getArrivalAirport());
	        }
	    }
	    if ( !(depOk && arrOk)){
	        throw new Exception("航班和输入的航段不一致");
	    }
	}
	
}

