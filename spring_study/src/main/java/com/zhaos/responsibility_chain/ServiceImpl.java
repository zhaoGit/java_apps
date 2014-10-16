package com.zhaos.responsibility_chain;

public class ServiceImpl implements Service{

	private Dao dao;

	public void sayWords(){
		dao.say();
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}
}
