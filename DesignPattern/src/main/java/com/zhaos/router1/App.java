package com.zhaos.router1;

/**
 *  @author zhaosheng
 *  简单工厂模式中关于产品选择的判断逻辑，通常在工厂类中，由if else实现，这样就不太符合开闭原则;
 *  	改进措施：由于参数决定了工厂生产的产品，因此可以使用一个映射表，事先将参数和产品的映射关系
 *  存放在一张表中，根据需要从这张表中根据参数查找相应的产品。
 *  一般的实现方式有两种：
 *  1、借助于Spring，可以完全实现开闭原则，参考route
 *  2、本实例展示的方式，参考route1；
 *  
 */
public class App {
	public static void main(String[] args){
		FlightMessage flightMessage = new FlightMessage();
		flightMessage.setMsg("hello, message");
		flightMessage.setMsgType(MessageType.FLT);
		EventGenerator manager = EventGeneratorManager.getEventGenerator();
		manager.generateEventList(flightMessage);
	}
}
