package com.zhaos.router1;


public class App {
	public static void main(String[] args){
		FlightMessage flightMessage = new FlightMessage();
		flightMessage.setMsg("hello, message");
		flightMessage.setMsgType(MessageType.GUI);
		EventGenerator manager = EventGeneratorManager.getEventGenerator();
		manager.generateEventList(flightMessage);
	}
}
