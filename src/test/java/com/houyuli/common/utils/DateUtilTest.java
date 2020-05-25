package com.houyuli.common.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

class DateUtilTest {

	@Test
	void testSubDate() {
		System.out.println(DateUtil.getString(DateUtil.SubDate(new Date(), 3), "yyyy-MM-dd"));
	}

	@Test
	void testGetAgeByBirthday() {
		Date date = DateUtil.getDate("1998/07/10", "yyyy/MM/dd");
		System.out.println(DateUtil.getAgeByBirthday(date));
	}

	@Test
	void testGetInitMonth() {
		String string = DateUtil.getString(DateUtil.getInitMonth(new Date()), "yyyy-MM-dd");
		System.out.println(string);
		System.out.println(DateUtil.getInitMonth(new Date()));
	}

	@Test
	void testGetEndMonth() {
		Date endMonth = DateUtil.getEndMonth(new Date());
		System.out.println(endMonth);
	}

	@Test
	void testRandom() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDisplayTime() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCurrentSeason() {
		fail("Not yet implemented");
	}

}
