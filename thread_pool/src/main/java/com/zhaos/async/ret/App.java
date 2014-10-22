package com.zhaos.async.ret;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args){
		ApplicationContext aContext = new ClassPathXmlApplicationContext("com/zhaos/async/applicationContext.xml");
		ICalc calc = aContext.getBean("calcImpl", ICalc.class);
		Future<Integer> result = calc.calc(2, 3);
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("end");
		((AbstractApplicationContext) aContext).close();
	}

}
