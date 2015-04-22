package com.zhaos.callable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Callable 和 Future接口
 * Callable是类似于Runnable的接口，实现Callable接口的类和实现Runnable的类都是可被其它线程执行的任务。
 * Callable和Runnable有几点不同： 
 * （1）Callable规定的方法是call()，而Runnable规定的方法是run().
 * （2）Callable的任务执行后可返回值，而Runnable的任务是不能返回值的。 
 * （3）call()方法可抛出异常，而run()方法是不能抛出异常的。
 * （4）运行Callable任务可拿到一个Future对象， Future表示异步计算的结果。
 * 它提供了检查计算是否完成的方法，以等待计算的完成，并检索计算的结果。
 * 通过Future对象可了解任务执行情况，可取消任务的执行，还可获取任务执行的结果。
 */
public class CallableAndFuture {

	/**
	 * �Զ���һ�������࣬ʵ��Callable�ӿ�
	 */
	public static class MyCallableClass implements Callable<Object> {
		// ��־λ
		private int flag = 0;

		public MyCallableClass(int flag) {
			this.flag = flag;
		}

		public String call() throws Exception {
			if (this.flag == 0) {
				// ���flag��ֵΪ0������������
				return "flag = 0";
			}
			if (this.flag == 1) {
				// ���flag��ֵΪ1����һ������ѭ��
				try {
					while (true) {
						System.out.println("looping......");
						Thread.sleep(2000);
					}
				} catch (InterruptedException e) {
					System.out.println("Interrupted");
				}
				return "false";
			} else {
				// falg��Ϊ0����1�����׳��쳣
				throw new Exception("Bad flag value!");
			}
		}
	}

	public static void main(String[] args) {
		// ����3��Callable���͵�����
		MyCallableClass task1 = new MyCallableClass(0);
		MyCallableClass task2 = new MyCallableClass(1);
		MyCallableClass task3 = new MyCallableClass(2);

		// ����һ��ִ������ķ���
		ExecutorService es = Executors.newFixedThreadPool(3);
		try {
			// �ύ��ִ��������������ʱ������һ��Future����
			// �����õ�����ִ�еĽ���������쳣�ɶ����Future������в���
			Future<?> future1 = es.submit(task1);
			// ��õ�һ������Ľ�����������get��������ǰ�̻߳�ȴ�����ִ����Ϻ������ִ��
			System.out.println("task1: " + future1.get());

			Future<?> future2 = es.submit(task2);
			// �ȴ�5�����ֹͣ�ڶ���������Ϊ�ڶ���������е�������ѭ��
			Thread.sleep(5000);
			System.out.println("task2 cancel: " + future2.cancel(true));

			// ��ȡ������������������Ϊִ�е���������������쳣
			// �����������佫�����쳣���׳�
			Future<?> future3 = es.submit(task3);
			System.out.println("task3: " + future3.get());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		// ֹͣ����ִ�з���
		es.shutdownNow();
	}
}