package com.zhaos.router1;

import java.util.List;

public abstract class EventGeneratorBase{
	//模板方法模式
	public List<Event> buildEventList(FlightMessage flightMessage) {
		EventParas paras = configParas();
		return buildEventList(flightMessage.getMsg(), paras);
	}
	
	//Hook method (to be extended)
	protected abstract List<Event> buildEventList(String messageStr, EventParas paras);
	//Hook method(to be extended)
	protected abstract EventParas configParas();
}
