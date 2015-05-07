package com.zhaos.router1;

import java.util.Collections;
import java.util.List;

//具体的Event生成类，也就是简单工厂模式的的产品
public class EventGeneratorForAircore extends EventGeneratorBase{
	@Override
	public List<Event> buildEventList(String messageStr, EventParas paras){
		System.out.println(MessageType.FLT + " " + paras.getDatePattern() + " aircore");
		return Collections.emptyList();
	}

	@Override
	protected EventParas configParas() {
		return new EventParas("MM/dd/yyyy");
	}
	
	//当调用Class.forName("com.zhaos.router1.EventGeneratorForAircore")时，会调用此静态初始化模块
	static{
		//每一个Event生成类负责把自己注册到统一管理的容器中
		EventGeneratorHolder.registerEventGenerator(MessageType.FLT, new EventGeneratorForAircore());
	}
}
