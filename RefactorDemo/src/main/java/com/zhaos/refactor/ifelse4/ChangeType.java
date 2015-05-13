package com.zhaos.refactor.ifelse4;

public enum ChangeType {

	CNL {
		@Override
		public Changer getChanger() {
			// TODO Auto-generated method stub
			return new CnlChanger();
		}
	},
	EQT {
		@Override
		public Changer getChanger() {
			// TODO Auto-generated method stub
			return new EqtChanger();
		}
	};

	public abstract Changer getChanger();
}
