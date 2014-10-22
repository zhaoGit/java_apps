package com.zhaos.no_ret;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/*定义一个封装了线程池的类： 
 * Server类主要是内部定义了ThreadPoolExecutor的成员变量和executeTask, endServer两个方法。
 * 他们一个用于分配线程并执行，另外一个用于关闭整个线程池。
 */

public class Server {
	private ThreadPoolExecutor executor;
	
	public Server() {
		executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
	}
	
	public void executeTask(Task task) {
		System.out.printf("Server: A new task has arrived\n");
		executor.execute(task);
		System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
		System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
		System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
	}
	
	public void endServer() {
		executor.shutdown();
	}
}
