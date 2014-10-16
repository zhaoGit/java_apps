package com.zhaos.responsibility_chain;

public abstract class DaoImpl extends Dao{

	public void say(){
		if(dao != null){
			dao.say();
		}
	}
}
