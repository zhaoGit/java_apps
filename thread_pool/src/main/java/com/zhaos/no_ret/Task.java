package com.zhaos.no_ret;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/*
 *  假定我们就通过线程池创建若干个线程，每个线程仅仅是休眠若干秒钟然后打印一些信息。
 *  我们可以这样来实现代码：
	首先定义要执行的线程：

 */
public class Task implements Runnable {
	private Date initDate;
	private String name;
	
	public Task(String name) {
		initDate = new Date();
		this.name = name;
	}
	
	public void run() {
		System.out.printf("%s: Task %s: Created on %s\n",
				Thread.currentThread().getName(), name, initDate);
		System.out.printf("%s: Task %s: Started on %s\n",
				Thread.currentThread().getName(), name, new Date());
		try {
			long duration = (long)(Math.random() * 10);
			System.out.printf("%s: Task %s: Doing a task during %d seconds\n",
					Thread.currentThread().getName(), name, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("%s: Task %s: Finished on: %s\n",
				Thread.currentThread().getName(), name, new Date());
	}
}
