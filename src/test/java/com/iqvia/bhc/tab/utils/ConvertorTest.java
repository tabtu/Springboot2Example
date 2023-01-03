package com.iqvia.bhc.tab.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.TimeZone;

import org.junit.jupiter.api.Test;

class ConvertorTest {

	@Test
	void test() {
		String datetimeStr = "2022-12-31T12:12:34";
		try {
			var calendar = Convertor.StringToCalendar(datetimeStr);
			String convBack = Convertor.DateToString(calendar.getTime());
			assertEquals(datetimeStr, convBack);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testConvertDatetimeWithTimezone() {
		// origin time
		String datetimeStr = "2022-12-31T12:34:56";
		String timeZone = "PST";
		// convert to EST time
		String dateTimeStrFixed = "2022-12-31T15:34:56";
		try {
			var calendar = Convertor.StringToCalendar(datetimeStr, timeZone);
			String convBack = Convertor.DateToString(calendar.getTime());
			assertEquals(dateTimeStrFixed, convBack);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
