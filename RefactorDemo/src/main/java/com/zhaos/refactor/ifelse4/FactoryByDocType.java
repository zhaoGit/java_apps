package com.zhaos.refactor.ifelse4;

public interface FactoryByDocType {

	Performer create(CnlChanger changeType);

	Performer create(EqtChanger eqtChanger);

}
