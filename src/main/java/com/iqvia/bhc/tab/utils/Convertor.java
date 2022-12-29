package com.iqvia.bhc.tab.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Convertor {

	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
	
	/**
	 * @param datetimeStr
	 * @return
	 * @throws ParseException
	 */
	public static Calendar StringToCalendar(String datetimeStr) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(datetimeStr));
		return calendar;
	}
	
	
	/**
	 * @param datetime
	 * @return
	 */
	public static String DateToString(Date datetime) {
		return sdf.format(datetime);
	}
}
