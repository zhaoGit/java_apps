package com.zhaos.bean_post_processor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * An ApplicationContext automatically detects any beans that are defined 
 * with implementation of the BeanPostProcessor interface and registers 
 * these beans as post-processors, to be then called appropriately by the 
 * container upon bean creation.
 * 
 * @author zhaosheng
 *
 */
public class App {
   @SuppressWarnings("resource")
public static void main(String[] args) {

      AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/zhaos/bean_post_processor/Beans.xml");

      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
      obj.getMessage();
      /*
       * Here you need to register a shutdown hook registerShutdownHook() method 
       * that is declared on the AbstractApplicationContext class. This will ensures 
       * a graceful shutdown and calls the relevant destroy methods.
       */
      context.registerShutdownHook();
   }
}