package com.zhaos.domain;

import javax.persistence.AttributeConverter;

import com.alibaba.fastjson.JSON;

public class UserConverter implements AttributeConverter<User, String>{

	@Override
	public String convertToDatabaseColumn(User arg0) {
		// TODO Auto-generated method stub
		return JSON.toJSONString(arg0);
	}

	@Override
	public User convertToEntityAttribute(String arg0) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setAddress(arg0);
		return JSON.parseObject(arg0, User.class);
	}
}
