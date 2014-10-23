package com.zhaos.async.noret;

import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:com/zhaos/async/noret/applicationContext.xml" })
public class AsyncNoRetTest {

	@Autowired
	private IGreeting greeting;

	@Test
	public void test() throws Exception {
		TestRunnable runner = new TestRunnable() {
			@Override
			public void runTest() throws Throwable {
				greeting.sayHello();
				System.out.println(Thread.currentThread().getName()+"****");
			}
		};
		MultiThreadedTestRunner mttr = new MultiThreadedTestRunner(
				new TestRunnable[] { runner });
		try {
			mttr.runTestRunnables();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " end");
		Thread.currentThread().sleep(10000);
	}
}
