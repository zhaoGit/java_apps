package com.zhaos.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/*
 * 应用场景：

1、某些耗时较长的而用户不需要等待该方法的处理结果
2、某些耗时较长的方法，后面的程序不需要用到这个方法的处理结果时
 */
@Service  
public class DaoService {  
    @Async  
    public void update() {  
        try {  
            Thread.sleep(2000);  
            // do something  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        System.out.println("operation complete.");  
    }  
}  
