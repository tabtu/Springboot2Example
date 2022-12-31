package com.iqvia.bhc.tab.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Convertor {

	/** date time format */
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
	
	/**
	 * Convert String to Calendar
	 * @param datetimeStr
	 * @return target calendar
	 * @throws ParseException
	 */
	public static Calendar StringToCalendar(String datetimeStr) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(datetimeStr));
		return calendar;
	}
	
	
	/**
	 * Convert Date to String
	 * @param date string
	 * @return DateString
	 */
	public static String DateToString(Date datetime) {
		return sdf.format(datetime);
	}
}
