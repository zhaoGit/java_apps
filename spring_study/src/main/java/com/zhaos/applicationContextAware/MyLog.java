package com.zhaos.applicationContextAware;

import org.springframework.stereotype.Service;

@Service
public class MyLog {

	public void info(String str){
		System.out.println(System.currentTimeMillis() + " " +str);
	}
}
