/**
 * 
 */
package com.zhaos.applicationContextAware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author zhaosheng
 *
 */
public class ToolSpring implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;
	/* 
	 * 
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		if(ToolSpring.applicationContext == null){
			ToolSpring.applicationContext = applicationContext;
		}
	}
	
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
	
	public static Object getBean(String name){
		return applicationContext.getBean(name);
	}
	
	public static<T> T getBean(String name, Class<T> clazz){
		return applicationContext.getBean(name, clazz);
	}
}
