package com.zhaos.responsibility_chain;

public class DaoA extends DaoImpl{

	public void say(){
		System.out.println("DaoA");
		super.say();
	}
}
