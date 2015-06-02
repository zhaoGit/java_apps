package com.zhaos.specification1;

import java.util.ArrayList;
/**
 *    LINQ提供了类似于 SQL 语法的遍历、筛选等功能，能完成对对象的查询，就像
 *    通过SQL语句查询数据库一样我们今天要讲的主题与LINQ有很大关系，它是实现LINQ的核心，是什么呢？
 *    想想SQL语句中什么是最复杂的，是where后面的查询条件，看看自己写的SQL语句
 *    基本上都是一长串的条件判断，中间一堆的and、or、not逻辑符。我们今天的任务
 *    就是要实现条件语句的解析，该部分实现了，基本上LINQ语法已经实现了一大半。
     我们以一个案例来讲解该技术，在内存中有10个User对象，根据不同的条件查找出用户，
     什么条件？比如姓名包含某个字符、年龄小于多少岁等等条件，类似这样的SQL.
 * @author zhaosheng
 *
 */
public class App {

	public static void main(String[] args) {
		// 首先初始化一批用户
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("苏大", 3));
		userList.add(new User("牛二", 8));
		userList.add(new User("张三", 10));
		userList.add(new User("李四", 15));
		userList.add(new User("王五", 18));
		userList.add(new User("赵六", 20));
		userList.add(new User("马七", 25));
		userList.add(new User("杨八", 30));
		userList.add(new User("侯九", 35));
		userList.add(new User("布十", 40));

		// 定义一个用户查询类
		IUserProvider userProvider = new UserProvider(userList);

		// 打印出年龄大于20岁的用户
		System.out.println("===年龄大于20岁的用户===");
		for (User u : userProvider.findUserByAgeThan(20)) {
			System.out.println(u);
		}
	}
}