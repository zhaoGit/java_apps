package com.zhaos.refactor.ifelse4;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Event event = new Event();
        event.setChangeType("CNL");
        event.setAsm(true);
        event.setDocType(DocType.ASM);
		new SimulatePlanGenerator().generate(event);
    }
}
