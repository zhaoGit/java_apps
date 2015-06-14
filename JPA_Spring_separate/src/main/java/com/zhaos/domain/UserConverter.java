package com.zhaos.domain;

import javax.persistence.AttributeConverter;

public class UserConverter implements AttributeConverter<User, String>{

	@Override
	public String convertToDatabaseColumn(User arg0) {
		// TODO Auto-generated method stub
		return arg0.getAddress();
	}

	@Override
	public User convertToEntityAttribute(String arg0) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setAddress(arg0);
		return user;
	}

}
