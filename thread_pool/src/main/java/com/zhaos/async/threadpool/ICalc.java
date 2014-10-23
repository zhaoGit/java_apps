package com.zhaos.async.threadpool;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;

public interface ICalc {

	@Async("fooExecutor")//用自己指定的线程池
	Future<Integer> calc(int a, int b);
}
