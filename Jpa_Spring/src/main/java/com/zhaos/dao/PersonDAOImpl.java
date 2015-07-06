package com.zhaos.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zhaos.domain.Person;
/**
 * Spring框架可以简化JPA的开发工作，具体体现在以下方面：
 * 1、首先，它使得 JPA 配置变得更加灵活。JPA 规范要求，配置文件必须命名为 persistence.xml，
 * 并存在于类路径下的 META-INF 目录中。该文件通常包含了初始化 JPA 引擎所需的全部信息。
 * Spring 提供的 LocalContainerEntityManagerFactoryBean 提供了非常灵活的配置，
 * persistence.xml 中的信息都可以在此以属性注入的方式提供。
 * 2、其次，Spring 实现了部分在 EJB 容器环境下才具有的功能，
 * 比如对 @PersistenceContext、@PersistenceUnit 的容器注入支持。
 * 3、第三，也是最具意义的，Spring 将 EntityManager 的创建与销毁、事务管理等代码抽取出来，
 * 并由其统一管理，开发者不需要关心这些，如前面的代码所示，业务方法中只剩下操作领域对象的代码，
 * 事务管理和 EntityManager 创建、销毁的代码都不再需要开发者关心了。
 *
 */
@Repository
public class PersonDAOImpl{

	/*
	 * There are two ways to get an EntityManager. One is with injection and the
	 * other through a factory. The injection option will only work for JEE
	 * applications, running inside applications servers The EntityManager
	 * injection, until today, will work only with a server that supports an EJB
	 * container.
	 * 
	 * When the application is JSE(desktop) application or when a web
	 * application want to handle the database connection manually just use .
	 */
	@PersistenceContext
	private EntityManager em;
	
	/*
	 * The @Transactional annotation is simply metadata that 
	 * can be consumed by some runtime infrastructure that is  
	 * @Transactional-aware and that can use the metadata to 
	 * configure the appropriate beans with transactional behavior. 
	 *  the  <tx:annotation-driven/>element  switches on 
	 *  the transactional behavior.Use the <tx:annotation-driven/> 
	 *  element for processing of Spring's @Transactional.
	 */
	@Transactional
	public Person savePerson(Person p) {
		 em.persist(p);
		 
		 return p;
	}
}
