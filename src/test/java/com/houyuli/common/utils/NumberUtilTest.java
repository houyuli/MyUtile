package com.houyuli.common.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberUtilTest {

	@Test
	void testIsReal() {
		System.out.println(NumberUtil.isReal("123"));
	}

	@Test
	void testIsNumber() {
		System.out.println(NumberUtil.isNumber("0.0"));
	}

	@Test
	void testRound() {
		System.out.println(NumberUtil.round(9.9999, 3));
	}

	@Test
	void testDiv() {
		System.out.println(NumberUtil.div(50, 20, 3));
	}

	@Test
	void testMul() {
		System.out.println(NumberUtil.mul(3.5, 2.1));
	}

	@Test
	void testSub() {
		System.out.println(NumberUtil.sub(6.99, 9.84));
	}

	@Test
	void testAdd() {
		System.out.println(NumberUtil.add(3.45, 84.21));
	}

}
