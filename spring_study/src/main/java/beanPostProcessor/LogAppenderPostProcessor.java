package beanPostProcessor;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class LogAppenderPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		
		Method[] methods = bean.getClass().getDeclaredMethods();
		for(Method method : methods){
			if(method.getAnnotation(RunningLog.class) != null){
				System.out.println("end log");
			}
		}
		
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("bean name " + beanName);

		Method[] methods = bean.getClass().getDeclaredMethods();
		for(Method method : methods){
			if(method.getAnnotation(RunningLog.class) != null){
				System.out.println("start log");
			}
		}
		
		return bean;
	}

}
