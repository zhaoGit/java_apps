package com.zhaos.synchronization;
/*
 * 1. 问题： 当多条语句在操作多线程共享的数据时，一个线程对多条语句执行了一部分但还没有执行完，
 * 另一个线程参与进来，导致共享数据错误。
 * 
 * 2. 解决办法： 对于有多条语句操作共享数据的多线程程序，只有当一个线程执行完，才能让另一个线程参与进来。
 * 也就是并行必须变成串行。
 * 
 * 3. 哪些代码需要同步，就看哪些代码在操作共享数据
 * 
 * 
 */

public class TicketSeller implements Runnable {

	private int ticket = 200;
	private Object obj = new Object();
	@Override
	public void run() {
		while (true) {
			synchronized (obj) {
				if (ticket > 0) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + " : "
							+ ticket--);
				} else {
					break;
				}
			}
		}
	}
}
