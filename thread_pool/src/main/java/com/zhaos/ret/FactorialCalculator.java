package com.zhaos.ret;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/*
 * 现在假定我们要使用一个线程池来调度几个线程。每个线程来计算一个 给定 数字的阶乘n!。
 * 那么，我们可以先定义需要提交计算的部分：
 */
public class FactorialCalculator implements Callable<Integer> {
	private Integer number;
	
	public FactorialCalculator(Integer number) {
		this.number = number;
	}
	
	public Integer call() throws Exception {
		int result = 1;
		
		if(number == 0 || number == 1) {
			result = 1;
		} else {
			for(int i = 2; i <= number; i++) {
				result *= i;
				TimeUnit.MILLISECONDS.sleep(200);
			}
		}
		System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);
		return result;
	}
}
