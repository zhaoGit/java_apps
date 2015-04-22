package com.zhaos.router;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EventGeneratorTest {

	@Autowired
	private EventManager eventManager;
	
	private FlightMessage flightMessage;
	
	@Before
	public void prepareParas(){
		flightMessage = new FlightMessage();
		flightMessage.setMsg("hello, message");
		flightMessage.setMsgType(MessageType.FLT);
	}
	@Test
	public void test() {
		eventManager.generateEventList(flightMessage);
	}

}
