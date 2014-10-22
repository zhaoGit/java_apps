package com.zhaos.ret;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/*
 * 定义了FactorialCalculator类。它实现了接口Callable。这个接口后面会被ThreadPoolExecutor的submit方法
 * 所用到。线程池在收到Callable的参数后会启动一个线程来执行call方法里的运算。还有一个需要注意到的地方是，我们这里定
 * 义了返回值是Integer类型的。
 * submit提交运算之后并不会马上得到结果。但是这个结果集我们可以将他们保存到一个列表中。在后面通过get的方法来获取。
 * 
 * 这里还有一个比较有意思的地方就是，在前面那种不返回结果的地方，我们是通过提交一个Runnable的参数给
 * ThreadPoolExecutor的execute方法来安排线程执行。这个我们好理解。可是在后面这个返回结果的地方，我们是提交了
 * 一个Callable的参数给ThreadPoolExecutor的submit方法。这里没有声明线程的东西，比如说我实现Runnable或者
 * 集成Thread，我怎么知道分配线程来执行call方法里面的东西呢？ 这个其实在ThreadPoolExecutor继承的类结构里有
 * 一个转换的方式，将Callable的变量绑定到一个线程对象实例当中，然后启动线程执行。
 */
public class Main {

	public static void main(String[] args) {
		//创建固定长度为2的线程池
                ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.
				newFixedThreadPool(2);
                // 声明保存返回结果的列表，注意类型为Future<Integer>
		List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
		Random random = new Random();

                // For循环中的submit方法在提交线程执行后会有一个返回类型为Future<Integer>的结果。将结果保存在列表中。
		for(int i = 0; i < 10; i++) {
			Integer number = random.nextInt(10);
			FactorialCalculator calculator = 
					new FactorialCalculator(number);
			Future<Integer> result = executor.submit(calculator);
			resultList.add(result);
		}

		System.out.printf("Main: Results\n");
		for(int i = 0; i < resultList.size(); i++) {
			Future<Integer> result = resultList.get(i);
			Integer number = null;
			try {
                                // 结果需要在线程执行完后才能get到，所以get执行时会使得线程等待，需要捕捉异常
				number = result.get();
			} catch(InterruptedException e) {
				e.printStackTrace();
			} catch(ExecutionException e) {
				e.printStackTrace();
			}
			System.out.printf("Main: Task %d: %d\n", i, number);
		}
		
                // 关闭线程池
		executor.shutdown();
	}
}