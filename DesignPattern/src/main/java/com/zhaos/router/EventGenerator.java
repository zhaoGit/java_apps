package com.zhaos.router;

import java.util.List;

public interface EventGenerator {

	List<Event> buildEventList(FlightMessage flightMessage);

}
