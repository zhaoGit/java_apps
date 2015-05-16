package com.zhaos.enumdeom.month;

/**
 * 
 * @author zhaosheng
 *
 */
public enum Month {
	JAN(MonType.BIG), 
	FEB(MonType.SPECIAL), 
	MAR(MonType.BIG), 
	APR(MonType.SMALL), 
	MAY(MonType.BIG), 
	JUN(MonType.SMALL);
	
	Month(MonType type) {
		this.type = type;
	}

	private final MonType type;

	public int ContainDays(int year) {
		return type.countMonthDays(year);
	}

	private enum MonType {
		BIG {
			public int countMonthDays(int num) {
				return 31;
			}
		},
		SMALL {
			public int countMonthDays(int num) {
				return 30;
			}
		},
		SPECIAL {
			public int countMonthDays(int num) {
				if ((num % 4 == 0 && num % 100 != 0) || (num % 400 == 0)) {
					return 28;
				} else {
					return 29;
				}
			}
		};
		public abstract int countMonthDays(int year);
	}
}
