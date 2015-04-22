package com.zhaos.deadlock;

public class DeadLockDemo implements Runnable{
	private boolean flag = true;
	public DeadLockDemo(boolean flag){
		this.flag = flag;
	}
	
	@Override
	public void run(){
		if(flag){
			synchronized (SynchronizedObject.lock1) {
				System.out.println("if lock1");
				synchronized(SynchronizedObject.lock2){
					System.out.println("if lock2");
				}
			}
		}else{
			synchronized(SynchronizedObject.lock2){
				System.out.println("if lock2");
				synchronized (SynchronizedObject.lock1) {
					System.out.println("else lock1");
				}
			}
		}
	}
	
	private static class SynchronizedObject{
		static final Object lock1 = new Object();
		static final Object lock2 = new Object();
	}
	
	public static void main(String[] args){
		Thread thread1 = new Thread(new DeadLockDemo(true));
		Thread thread2 = new Thread(new DeadLockDemo(false));
		
		thread1.start();
		thread2.start();
	}
}
