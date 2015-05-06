package com.zhaos.strEqual;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zhaos.builder.DesignatorBuilder;
/**
 *  本示例主要用于展示如下书写自动化单元测试
 * @author zhaosheng
 *
 */
public class DesignatorEqualsTest {

	/**
	 * Case1: CA1203A==CA1203A
	 */
	@Test
	public void test_Equal_CA1203A_and_CA1203A_should_return_true() {
		Designator designator1 = buildDesignator("CA", "1203", "A");
		Designator designator2 = buildDesignator("CA", "1203", "A");
		assertEquals(designator1, designator2);
	}
	
	/**
	 * Case2: CA1203A==CA1203
	 */
	@Test
	public void test_Equal_CA1203A_and_CA1203null_should_return_false() {
		Designator designator1 = buildDesignator("CA", "1203", "A");
		Designator designator2 = buildDesignator("CA", "1203", null);
		assertFalse(designator1.equals(designator2));
	}
	
	/**
	 * Case3: CA1203A==CA1203
	 */
	@Test
	public void test_Equal_CA1203A_and_CA1203empty_should_return_false() {
		Designator designator1 = buildDesignator("CA", "1203", "A");
		Designator designator2 = buildDesignator("CA", "1203", "");
		assertFalse(designator1.equals(designator2));
	}
	
	/**
	 * Case4: CA1203empty==CA1203null
	 */
	@Test
	public void test_Equal_CA1203empty_and_CA1203null_should_return_false() {
		Designator designator1 = buildDesignator("CA", "1203", "");
		Designator designator2 = buildDesignator("CA", "1203", null);
		assertFalse(designator1.equals(designator2));
	}
	
	/**
	 * Case5: CA1203empty==CA1203empty
	 */
	@Test
	public void test_Equal_CA1203empty_and_CA1203empty_should_return_false() {
		Designator designator1 = buildDesignator("CA", "1203", "");
		Designator designator2 = buildDesignator("CA", "1203", "");
		assertTrue(designator1.equals(designator2));
	}
	
	/**
	 * Case6: CA1203null==CA1203null
	 */
	@Test
	public void test_Equal_CA1203null_and_CA1203null_should_return_false() {
		Designator designator1 = buildDesignator("CA", "1203", null);
		Designator designator2 = buildDesignator("CA", "1203", null);
		assertTrue(designator1.equals(designator2));
	}
	
	/**
	 * Case7: MU1203A==CA1203A
	 */
	@Test
	public void test_Equal_MU1203null_and_CA1203null_should_return_false() {
		Designator designator1 = buildDesignator("MU", "1203", "A");
		Designator designator2 = buildDesignator("CA", "1203", "A");
		assertFalse(designator1.equals(designator2));
	}
	
	/**
	 * Case8: MU1203A==CA1203A
	 */
	@Test
	public void test_Equal_Designator_and_AnyObject_should_return_false() {
		Designator designator1 = buildDesignator("MU", "1203", "A");
		Object object = new Object();
		assertFalse(designator1.equals(object));
	}
	
	/**
	 * Case9: MU1203A==null
	 */
	@Test
	public void test_Equal_Designator_and_NULL_should_return_false() {
		Designator designator1 = buildDesignator("MU", "1203", "A");
		assertFalse(designator1.equals(null));
	}
	
	
	private Designator buildDesignator(String airline, String number, String suffix){
		return DesignatorBuilder
				.startBuilder()
				.withAirline(airline)
				.withNumber(number)
				.withSuffix(suffix)
				.build();
	}

}
