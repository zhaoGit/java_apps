/*
 * 	       生产者消费者模型的Java实现方式---等待唤醒机制
 * 一. 注意：
 * 		1. 此种模式可用于多个线程生产， 多个线程消费的情形。
 *		2. 多个线程共用一个同步对象。
 * 二. 对于多个生产者消费者，定义while循环判断标志是因为让被唤醒的线程
 * 三. 定义notifyAll，因为需要唤醒对方线程，用notify容易出现只唤醒本方线程
 * 		的情形，导致程序中的所有线程都等待。
 *
 */
package com.zhaos.synchronized_wait_notify;


/*
 * 一般把多线程共享数据和方法封装在同一个类中，这样更能符合面向对象的编程思想，程序
 * 的内聚性更强。
 */
class Resource{
	private String name;
	private int num = 1;
	
	//标志变量，true表示数据准备好，已被赋值；false表示数据为空，还未准备好。
	boolean bReady = false;
	//同步方法的对象是this，整个方法块的内容为同步的范围
	public synchronized void SetProp(String name){
		//为了观察效果
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//数据已经准备好，生产者线程就要等待，不能赋值。
		while(bReady){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.name = name + "---"+ num++;
		System.out.println(Thread.currentThread().getName() + "..." + "producer " + this.name);
		//数据赋值后，要把变量赋值为true.
		this.bReady = true;
		//唤醒消费之线程，执行消费者的run方法。
		this.notifyAll();
	}
	
	//消费者线程的之执行代码
	public synchronized void outPut(){

		//先检查数据是否准备就绪。
		while(!bReady){
			try {
				this.wait();//数据未被赋值，则进行等待。
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(Thread.currentThread().getName() + ".........." + "consumer " + this.name);
		this.bReady = false;//数据已经被消费
		this.notifyAll();//唤醒生产者线程。
	}
}

class Producer implements Runnable{

	private Resource resource;
	
	public Producer(Resource resource) {
		super();
		this.resource = resource;
	}

	@Override
	public void run() {
		while(true){
			resource.SetProp("Goods");
		}
	}
	
}

class Consumer implements Runnable{

	private Resource resource;
	
	public Consumer(Resource resource) {
		super();
		this.resource = resource;
	}

	@Override
	public void run() {
		while (true) {
			resource.outPut();
		}
	}
	
}

public class NotifyTest {

	public static void main(String[] args) {

		Resource resource = new Resource();
		
		Thread thread1 = new Thread(new Producer(resource));
		Thread thread2 = new Thread(new Producer(resource));
		Thread thread3 = new Thread(new Consumer(resource));
		Thread thread4 = new Thread(new Consumer(resource));
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}
