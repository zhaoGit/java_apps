package com.zhaos.async.noret;

import org.springframework.stereotype.Service;

@Service//不写名字，默认的就是greeting
public class Greeting implements IGreeting {

	public void sayHello() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " hello async...");
	}

}
