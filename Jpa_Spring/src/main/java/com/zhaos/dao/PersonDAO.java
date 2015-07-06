package com.zhaos.dao;

import org.springframework.data.repository.Repository;

import com.zhaos.domain.Person;
/**
 * 有些时候，开发者可能需要在某些方法中做一些特殊的处理，
 * 此时自动生成的代理对象不能完全满足要求。为了享受 Spring Data JPA 带给我们的便利，
 * 同时又能够为部分方法提供自定义实现，我们可以采用如下的方法
 * @author zhaosheng
 *
 */
public interface PersonDAO extends Repository<Person,String>, PersonRepository{

	Person findById(String id);
}
