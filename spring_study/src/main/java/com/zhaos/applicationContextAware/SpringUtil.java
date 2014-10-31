package com.zhaos.applicationContextAware;

public class SpringUtil {

	public static int getLength(String str){
		ToolSpring.getBean("log", MyLog.class).info(str);
		return str.length();
	}
}
