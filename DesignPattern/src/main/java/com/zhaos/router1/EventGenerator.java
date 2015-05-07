package com.zhaos.router1;

import java.util.List;

public interface EventGenerator {

	List<Event> buildEventList(FlightMessage flightMessage);

}
