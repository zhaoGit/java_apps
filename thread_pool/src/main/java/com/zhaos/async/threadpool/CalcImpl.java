package com.zhaos.async.threadpool;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

/*
 * 使用Spring的异步标签，异步调用一个方法并且有返回值。关键点看是如何返回值的
 */
@Service
public class CalcImpl implements ICalc{

	public Future<Integer> calc(int a, int b) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+ " calc...");
		return new AsyncResult<Integer>(a+b);
	}

	
}
