package com.zhaos.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhaos.domain.ClassEntity;
/**
 * Spring 对 JPA 的支持已经非常强大，开发者只需关心核心业务逻辑的实现代码，
 * 无需过多关注 EntityManager 的创建、事务处理等 JPA 相关的处理，
 * 这基本上也是作为一个开发框架而言所能做到的极限了。然而，
 * Spring 开发小组并没有止步，他们再接再厉，于最近推出了 Spring Data JPA 框架，
 * 主要针对的就是 Spring 唯一没有简化到的数据访问层代码(增删改查)，至此，开发者连仅剩的实现
 * 持久层逻辑的工作都省了，唯一要做的，就只是声明持久层的接口，
 * 其他都交给 Spring Data JPA 来帮你完成！
 * @author zhaosheng
 *
 */
public interface ClassEntityDAO extends JpaRepository<ClassEntity, String>{

}
