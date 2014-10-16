package com.zhaos.responsibility_chain;

public abstract class Dao {

	public abstract void say();
	
	protected Dao dao;

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
}
