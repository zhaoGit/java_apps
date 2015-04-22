package com.zhaos.completeservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/*
 * Future<V>代表一个异步执行的操作，通过get()方法可以获得操作的结果，如果异步操作还没有完成，
 * 则get()会使当前线程阻塞。FutureTask<V>实现了Future<V>和Runable<V>。Callable代
 * 表一个有返回值得操作。
 */
public class ConcurrentSum {
	
	private int coreCpuNum;
	private ExecutorService executor;
	private List<FutureTask<Long>> tasks = new ArrayList<FutureTask<Long>>();

	public ConcurrentSum() {
		coreCpuNum = Runtime.getRuntime().availableProcessors();
		executor = Executors.newFixedThreadPool(coreCpuNum);
	}

	class SumCalculator implements Callable<Long> {
		int nums[];
		int start;
		int end;

		public SumCalculator(final int nums[], int start, int end) {
			this.nums = nums;
			this.start = start;
			this.end = end;
		}

		@Override
		public Long call() throws Exception {
			long sum = 0;
			for (int i = start; i < end; i++) {
				sum += nums[i];
			}
			return sum;
		}
	}

	public long sum(int[] nums) {
		int start, end, increment;
		// ����CPU���ĸ���������񣬴���FutureTask���ύ��Executor
		for (int i = 0; i < coreCpuNum; i++) {
			increment = nums.length / coreCpuNum + 1;
			start = i * increment;
			end = start + increment;
			if (end > nums.length) {
				end = nums.length;
			}
			SumCalculator calculator = new SumCalculator(nums, start, end);
			FutureTask<Long> task = new FutureTask<Long>(calculator);
			tasks.add(task);
			if (!executor.isShutdown()) {
				/*
				 * ExecutoreService�ṩ��submit()����������һ��Callable����Runnable��
				 * ����Future�����Executor��̨�̳߳ػ�û�����Callable�ļ��㣬
				 * ����÷���Future�����get()������������ֱ��������ɡ�
				 */
				executor.submit(task);
			}
		}
		return getPartSum();
	}

	public long getPartSum() {
		long sum = 0;
		for (int i = 0; i < tasks.size(); i++) {
			try {
				sum += tasks.get(i).get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		return sum;
	}

	public void close() {
		executor.shutdown();
	}

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 22, 33, 4, 52, 61, 7, 48, 10, 11 };
		long sum = new ConcurrentSum().sum(arr);
		System.out.println("sum: " + sum);
	}
}