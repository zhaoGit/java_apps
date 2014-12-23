package com.zhaos.segmentMatchFlight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一个航班由若干个航节组成，其中几个连续的航节组成了航段。给一个任意的航班，和一个航段，判断这个航段是不是这个航班的。
 *Case1: no circle
 *		legs: A----B----C----D
 *		segs:A----C
 *Case2: circle flight
 *		legs : A----B----C-----D-----A
 */
public class App 
{
    public static void main( String[] args )
    {
        Leg leg1 = new Leg();
        leg1.setDeptAirport("PEK");
        leg1.setArrivalAirport("CTU");
        
        Leg leg2 = new Leg();
        leg2.setDeptAirport("CTU");
        leg2.setArrivalAirport("XIY");
        
        Leg leg3 = new Leg();
        leg3.setDeptAirport("XIY");
        leg3.setArrivalAirport("PVG");
        List<Leg> legList = new ArrayList<Leg>(){
        	/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
        		add(leg1);
        		add(leg2);
        		add(leg3);
        	}        	
        };
        
        Segment segment1 = new Segment();
        segment1.setDeptAirport("PEK");
        segment1.setArrivalAirport("PVG");
        
        try {
			FlightMatchSegments.validFlightMatchSegments(legList, Arrays.asList(segment1));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
}
