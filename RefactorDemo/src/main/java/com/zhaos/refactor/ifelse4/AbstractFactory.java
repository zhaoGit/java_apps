package com.zhaos.refactor.ifelse4;

import javax.annotation.PostConstruct;

public abstract class AbstractFactory implements Factory{

	@PostConstruct
	protected abstract void initial();
}
