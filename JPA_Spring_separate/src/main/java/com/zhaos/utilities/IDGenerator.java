package com.zhaos.utilities;

import java.util.UUID;

public class IDGenerator {

	public static String getUUID(){
		String uuid = UUID.randomUUID().toString();
		StringBuffer buffer = new StringBuffer(uuid);
		buffer.deleteCharAt(8);
		buffer.deleteCharAt(12);
		buffer.deleteCharAt(16);
		buffer.deleteCharAt(20);
		return buffer.toString().toUpperCase();
	}

}
