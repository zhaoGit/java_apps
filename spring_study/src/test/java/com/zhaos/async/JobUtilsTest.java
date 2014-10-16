package com.zhaos.async;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:async/applicationContext.xml" })  
public class JobUtilsTest{  
      
    @Autowired  
    private DaoService service;  
  
    @Test  
    public void testAsync() throws Exception {  
        System.out.println("start" );  
        service.update(); // ★ 假设这个方法会比较耗时，需要异步执行  
        System.out.println("end");  
          
          
        Thread.sleep(3000); // 因为junit结束会结束jvm，所以让它等会异步线程  
    }  
} 
