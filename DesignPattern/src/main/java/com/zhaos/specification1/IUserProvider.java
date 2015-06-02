package com.zhaos.specification1;

import java.util.ArrayList;

public interface IUserProvider {

	// 根据用户名查找用户

	public ArrayList<User> findUserByNameEqual(String name);

	// 年龄大于指定年龄的用户

	public ArrayList<User> findUserByAgeThan(int age);

}