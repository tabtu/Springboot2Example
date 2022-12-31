package com.iqvia.bhc.tab.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConvertorTest {

	@Test
	void test() {
		String datetimeStr = "2022-12-31 12:12:34";
		try {
			var calendar = Convertor.StringToCalendar(datetimeStr);
			String convBack = Convertor.DateToString(calendar.getTime());
			assertEquals(datetimeStr, convBack);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
