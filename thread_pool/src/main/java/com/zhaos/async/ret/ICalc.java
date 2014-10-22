package com.zhaos.async.ret;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;

public interface ICalc {

	@Async
	Future<Integer> calc(int a, int b);
}
