package com.zhaos.refactor.ifelse2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/zhaos/refactor/ifelse2/applicationContext.xml");
		SimulatePlanGenerator simulatePlanGenerator = applicationContext
				.getBean("simulatePlanGenerator", SimulatePlanGenerator.class);
		Event event = new Event();
		event.setChangeType("TIM");
		event.setAsm(true);
		simulatePlanGenerator.generate(event);
		applicationContext.close();
	}
}
