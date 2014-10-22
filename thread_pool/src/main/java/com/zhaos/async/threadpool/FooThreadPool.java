package com.zhaos.async.threadpool;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.util.Assert;

/*
 * 自定义可配置的线程池
 */
public class FooThreadPool implements ExecutorService {

	private final Object poolSizeMonitor = new Object();

	private String threadPoolName = "";

	private int corePoolSize = 1;

	private int maxPoolSize = Integer.MAX_VALUE;

	private int keepAliveSeconds = 60;

	private boolean allowCoreThreadTimeOut = false;

	private int queueCapacity = Integer.MAX_VALUE;
	
	private RejectedExecutionHandler rejectedExecutionHandler;

	private ThreadPoolExecutor threadPoolExecutor;

	/**
	 * Set the ThreadPoolExecutor's core pool size. Default is 1.
	 * <p>
	 * <b>This setting can be modified at runtime, for example through JMX.</b>
	 */
	public void setCorePoolSize(int corePoolSize) {
		synchronized (this.poolSizeMonitor) {
			this.corePoolSize = corePoolSize;
			if (this.threadPoolExecutor != null) {
				this.threadPoolExecutor.setCorePoolSize(corePoolSize);
			}
		}
	}

	/**
	 * Return the ThreadPoolExecutor's core pool size.
	 */
	public int getCorePoolSize() {
		synchronized (this.poolSizeMonitor) {
			return this.corePoolSize;
		}
	}

	/**
	 * Set the ThreadPoolExecutor's maximum pool size. Default is
	 * {@code Integer.MAX_VALUE}.
	 * <p>
	 * <b>This setting can be modified at runtime, for example through JMX.</b>
	 */
	public void setMaxPoolSize(int maxPoolSize) {
		synchronized (this.poolSizeMonitor) {
			this.maxPoolSize = maxPoolSize;
			if (this.threadPoolExecutor != null) {
				this.threadPoolExecutor.setMaximumPoolSize(maxPoolSize);
			}
		}
	}

	/**
	 * Return the ThreadPoolExecutor's maximum pool size.
	 */
	public int getMaxPoolSize() {
		synchronized (this.poolSizeMonitor) {
			return this.maxPoolSize;
		}
	}

	/**
	 * Set the ThreadPoolExecutor's keep-alive seconds. Default is 60.
	 * <p>
	 * <b>This setting can be modified at runtime, for example through JMX.</b>
	 */
	public void setKeepAliveSeconds(int keepAliveSeconds) {
		synchronized (this.poolSizeMonitor) {
			this.keepAliveSeconds = keepAliveSeconds;
			if (this.threadPoolExecutor != null) {
				this.threadPoolExecutor.setKeepAliveTime(keepAliveSeconds,
						TimeUnit.SECONDS);
			}
		}
	}

	/**
	 * Return the ThreadPoolExecutor's keep-alive seconds.
	 */
	public int getKeepAliveSeconds() {
		synchronized (this.poolSizeMonitor) {
			return this.keepAliveSeconds;
		}
	}

	public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler){
		synchronized (this.poolSizeMonitor) {
			this.rejectedExecutionHandler = rejectedExecutionHandler;
			if(this.threadPoolExecutor != null){
				this.threadPoolExecutor.setRejectedExecutionHandler(rejectedExecutionHandler);
			}
			
		}
	}
	
	public RejectedExecutionHandler getRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler){
		return this.rejectedExecutionHandler;
	}
	/**
	 * Specify whether to allow core threads to time out. This enables dynamic
	 * growing and shrinking even in combination with a non-zero queue (since
	 * the max pool size will only grow once the queue is full).
	 * <p>
	 * Default is "false".
	 * 
	 * @see java.util.concurrent.ThreadPoolExecutor#allowCoreThreadTimeOut(boolean)
	 */
	public void setAllowCoreThreadTimeOut(boolean allowCoreThreadTimeOut) {
		this.allowCoreThreadTimeOut = allowCoreThreadTimeOut;
	}

	/**
	 * Set the capacity for the ThreadPoolExecutor's BlockingQueue. Default is
	 * {@code Integer.MAX_VALUE}.
	 * <p>
	 * Any positive value will lead to a LinkedBlockingQueue instance; any other
	 * value will lead to a SynchronousQueue instance.
	 * 
	 * @see java.util.concurrent.LinkedBlockingQueue
	 * @see java.util.concurrent.SynchronousQueue
	 */
	public void setQueueCapacity(int queueCapacity) {
		this.queueCapacity = queueCapacity;
	}

	public ExecutorService init() {

		ThreadFactory threadFactory = new CustomizableThreadFactory(
				this.threadPoolName + "-");
		BlockingQueue<Runnable> queue = createQueue(this.queueCapacity);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(this.corePoolSize,
				this.maxPoolSize, this.keepAliveSeconds, TimeUnit.SECONDS,
				queue, threadFactory, rejectedExecutionHandler);
		if (this.allowCoreThreadTimeOut) {
			executor.allowCoreThreadTimeOut(true);
		}

		this.threadPoolExecutor = executor;
		return executor;
	}

	public void destroy() {
		List<Runnable> runnables = getThreadPoolExecutor().shutdownNow();
		if (runnables.size() > 0) {
			System.out.println("线程池关闭时，还有在执行的任务...");
		}
	}

	/**
	 * Create the BlockingQueue to use for the ThreadPoolExecutor.
	 * <p>
	 * A LinkedBlockingQueue instance will be created for a positive capacity
	 * value; a SynchronousQueue else.
	 * 
	 * @param queueCapacity
	 *            the specified queue capacity
	 * @return the BlockingQueue instance
	 * @see java.util.concurrent.LinkedBlockingQueue
	 * @see java.util.concurrent.SynchronousQueue
	 */
	protected BlockingQueue<Runnable> createQueue(int queueCapacity) {
		if (queueCapacity > 0) {
			return new LinkedBlockingQueue<Runnable>(queueCapacity);
		} else {
			return new SynchronousQueue<Runnable>();
		}
	}

	/**
	 * Return the underlying ThreadPoolExecutor for native access.
	 * 
	 * @return the underlying ThreadPoolExecutor (never {@code null})
	 * @throws IllegalStateException
	 *             if the ThreadPoolTaskExecutor hasn't been initialized yet
	 */
	public ThreadPoolExecutor getThreadPoolExecutor()
			throws IllegalStateException {
		Assert.state(this.threadPoolExecutor != null,
				"ThreadPoolTaskExecutor not initialized");
		return this.threadPoolExecutor;
	}

	/**
	 * Return the current pool size.
	 * 
	 * @see java.util.concurrent.ThreadPoolExecutor#getPoolSize()
	 */
	public int getPoolSize() {
		if (this.threadPoolExecutor == null) {
			// Not initialized yet: assume core pool size.
			return this.corePoolSize;
		}
		return this.threadPoolExecutor.getPoolSize();
	}

	/**
	 * Return the number of currently active threads.
	 * 
	 * @see java.util.concurrent.ThreadPoolExecutor#getActiveCount()
	 */
	public int getActiveCount() {
		if (this.threadPoolExecutor == null) {
			// Not initialized yet: assume no active threads.
			return 0;
		}
		return this.threadPoolExecutor.getActiveCount();
	}

	@Override
	public void execute(Runnable task) {
		Executor executor = getThreadPoolExecutor();
		executor.execute(task);
	}

	@Override
	public void shutdown() {
		getThreadPoolExecutor().shutdown();
	}

	@Override
	public List<Runnable> shutdownNow() {
		return getThreadPoolExecutor().shutdownNow();
	}

	@Override
	public boolean isShutdown() {
		return getThreadPoolExecutor().isShutdown();
	}

	@Override
	public boolean isTerminated() {
		return getThreadPoolExecutor().isTerminated();
	}

	@Override
	public boolean awaitTermination(long timeout, TimeUnit unit)
			throws InterruptedException {
		return getThreadPoolExecutor().awaitTermination(timeout, unit);
	}

	@Override
	public <T> Future<T> submit(Callable<T> task) {
		return getThreadPoolExecutor().submit(task);
	}

	@Override
	public <T> Future<T> submit(Runnable task, T result) {
		return getThreadPoolExecutor().submit(task, result);
	}

	@Override
	public Future<?> submit(Runnable task) {
		// TODO Auto-generated method stub
		return getThreadPoolExecutor().submit(task);
	}

	@Override
	public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<Future<T>> invokeAll(
			Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
			throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks)
			throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T invokeAny(Collection<? extends Callable<T>> tasks,
			long timeout, TimeUnit unit) throws InterruptedException,
			ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getThreadPoolName() {
		return threadPoolName;
	}

	public void setThreadPoolName(String threadPoolName) {
		this.threadPoolName = threadPoolName;
	}

}
