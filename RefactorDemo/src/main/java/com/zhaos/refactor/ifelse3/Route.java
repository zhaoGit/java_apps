package com.zhaos.refactor.ifelse3;

public interface Route {

	Performer getPerformer(ChangeType changeType);

	void register(ChangeType changeType, Performer performer);
}
