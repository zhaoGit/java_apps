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
		/*
		 * Junit单元测试不支持并发，Junit本身是不支持普通的多线程测试的，这是因为Junit的底层实现上，
		 * 是用System.exit退出用例执行的。JVM都终止了，在测试线程启动的其他线程自然也无法执行。
		 */
		greeting.sayHello();
		Thread.sleep(1000);
		System.out.println("end");
	}
}
