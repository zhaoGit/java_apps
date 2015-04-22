package com.zhaos.router;

import java.util.List;

public interface EventManager {

	List<Event> generateEventList(FlightMessage flightMessage);

}
