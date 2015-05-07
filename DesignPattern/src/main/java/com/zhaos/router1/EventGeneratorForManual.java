package com.zhaos.router1;

import java.util.Collections;
import java.util.List;

//负责Event生成的类，是简单工厂模式的产品
public class EventGeneratorForManual extends EventGeneratorBase{

	@Override
	public List<Event> buildEventList(String messageStr, EventParas paras) {
		System.out.println(MessageType.GUI +" " + paras.getDatePattern() + " GUI");
		return Collections.emptyList();
	}

	@Override
	protected EventParas configParas() {
		return new EventParas("yyyy-MM-dd");
	}
	
	//当调用Class.forName("com.zhaos.router1.EventGeneratorForManual")时会调用此静态模块
	static{
		EventGeneratorHolder.registerEventGenerator(MessageType.GUI, new EventGeneratorForManual());
	}
}
