package com.zhaos.async.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	public static void main(String[] args){
		ClassPathXmlApplicationContext aContext = new ClassPathXmlApplicationContext("com/zhaos/async/threadpool/applicationContext.xml");
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
		//关闭context来触发执行bean销毁方法 
		aContext.close();
	}

}
