package com.zhaos.refactor.ifelse5;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/zhaos/refactor/ifelse5/applicationContext.xml");
        SimulatePlanGenerator simulatePlanGenerator = applicationContext.getBean("simulatePlanGenerator", SimulatePlanGenerator.class);
        Event event = new Event();
        event.setChangeType("CNL");
        event.setDocType(DocType.SSM);
		simulatePlanGenerator.generate(event );
		applicationContext.close();
    }
}
