package com.zhaos.async;

import org.springframework.scheduling.annotation.Async;

public interface IGreeting {
	/*
	 * 1. 必须在配置文件中配置上<task:annotation-driven /> ，否则Spring不能异步执行
	 * 2. 异步执行的类必须被Spring管理
	 * 3. Async既可以打在接口上也可以打在实现类上
	 */
	@Async
	void sayHello();		
}
