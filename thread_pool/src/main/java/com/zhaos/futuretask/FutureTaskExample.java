package com.zhaos.futuretask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
 * Java 5在concurrency包中引入了java.util.concurrent.Callable 接口，它和Runnable接口很相似，
 * 但它可以返回一个对象或者抛出一个异常。

    Callable接口使用泛型去定义它的返回类型。Executors类提供了一些有用的方法在线程池中执行Callable内的任务。
    由于Callable任务是并行的（并行就是整体看上去是并行的，其实在某个时间点只有一个线程在执行），我们必须等待它返回的结果。

    java.util.concurrent.Future对象为我们解决了这个问题。在线程池提交Callable任务后返回了一个Future对象，
    使用它可以知道Callable任务的状态和得到Callable返回的执行结果。Future提供了get()方法让我们可以等待Callable
    结束并获取它的执行结果。

Future用于表示异步计算的结果。它的实现类是FutureTask。如果不想分支线程阻塞主线程，又想取得分支线程的执行结果，就用
FutureTask.提供了两个构造函数，一个以Callable为参数，另外一个以Runnable为参数。这些类之间的关联对于任务建模的办
法非常灵活，允许你基于FutureTask的Runnable特性（因为它实现了Runnable接口），把任务写成Callable，然后封装进一
个由执行者调度并在必要时可以取消的FutureTask。
FutureTask可以由执行者调度，这一点很关键。它对外提供的方法基本上就是Future和Runnable接口的组合：get()、cancel、
isDone()、isCancelled()和run()，而run()方法通常都是由执行者调用，我们基本上不需要直接调用它.


 */

public class FutureTaskExample {
     public static void main(String[] args) {
        MyCallable callable1 = new MyCallable(1000);                       // 要执行的任务
        MyCallable callable2 = new MyCallable(2000);

        FutureTask<String> futureTask1 = new FutureTask<String>(callable1);// 将Callable写的任务封装到一个由执行者调度的FutureTask对象
        FutureTask<String> futureTask2 = new FutureTask<String>(callable2);
 
        ExecutorService executor = Executors.newFixedThreadPool(2);        // 创建线程池并返回ExecutorService实例
        executor.execute(futureTask1);  // 执行任务
        executor.execute(futureTask2);  
         
        while (true) {
            try {
                if(futureTask1.isDone() && futureTask2.isDone()){//  两个任务都完成
                    System.out.println("Done");
                    executor.shutdown();                          // 关闭线程池和服务 
                    return;
                }
                 
                if(!futureTask1.isDone()){ // 任务1没有完成，会等待，直到任务完成
                    System.out.println("FutureTask1 output="+futureTask1.get());
                }
                 
                System.out.println("Waiting for FutureTask2 to complete");
                String s = futureTask2.get(200L, TimeUnit.MILLISECONDS);
                if(s !=null){
                    System.out.println("FutureTask2 output="+s);
                }
            }catch(InterruptedException e){
            	e.printStackTrace();
            }
            catch (ExecutionException e) {
                e.printStackTrace();
            }catch(TimeoutException e){
                //do nothing
            }
        }
    }
}