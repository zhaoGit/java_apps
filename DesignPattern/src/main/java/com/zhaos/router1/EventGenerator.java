package com.zhaos.router1;

import java.util.List;

public interface EventGenerator {
	//Event生成模块对外暴露的接口
	List<Event> generateEventList(FlightMessage flightMessage);
}
