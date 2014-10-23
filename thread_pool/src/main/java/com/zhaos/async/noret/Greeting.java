package com.zhaos.async.noret;

import org.springframework.stereotype.Service;

@Service//不写名字，默认的就是greeting
public class Greeting implements IGreeting {

	public void sayHello() {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " ****************hello async...");
	}

}
