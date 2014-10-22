package com.zhaos.no_ret;
/*
 * 通常来说，我们使用线程可以分为两种类型。一种是使用多个线程执行某些任务，但不一定要将线程执行的结果统一
 * 返回并统计。另外一种则需要将线程执行的结果统一记录和统计。我们就针对这两种情况来尝试。
 */
public class Main {

	public static void main(String[] args) {
		Server server = new Server();
		for(int i = 0; i < 10; i++) {
			Task task = new Task("Task " + i);
			server.executeTask(task);
		}
		server.endServer();
	}
}