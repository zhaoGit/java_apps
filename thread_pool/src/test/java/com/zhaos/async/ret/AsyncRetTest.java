package com.zhaos.async.ret;

import java.util.concurrent.Future;

import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/zhaos/async/ret/applicationContext.xml"})
public class AsyncRetTest {

	@Autowired
	private ICalc calc;	
	
	private int THREAD_NUMS = 5;
	
	@Test
	public void test() {
/*		Future<Integer> result = calc.calc(2, 3);
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}*/
		
		TestRunnable runner = new TestRunnable() {
			@Override
			public void runTest() throws Throwable {
				Future<Integer> result = calc.calc(2, 3);
				System.out.println(Thread.currentThread().getName()+"****"+result.get());
			}
		};
		
		TestRunnable[] runArray = new TestRunnable[this.THREAD_NUMS];
		for(int i=0; i<runArray.length; i++){
			runArray[i] = runner;
		}
		
		MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(runArray);
		try {
			mttr.runTestRunnables();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}
