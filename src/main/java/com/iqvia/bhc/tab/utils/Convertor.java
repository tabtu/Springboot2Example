package com.iqvia.bhc.tab.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Convertor {

	/** date time format */
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
	
	private final static TimeZone defaultTimeZone = TimeZone.getDefault();
	
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
	 * Convert String to Calendar identify with TimeZone
	 * @param datetimeStr standard date time string
	 * @param timeZone time zone string
	 * @return date time in default time zone
	 * @throws ParseException
	 */
	public static Calendar StringToCalendar(String datetimeStr, String timeZone) throws ParseException {
		// change time zone setting
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		Date date = sdf.parse(datetimeStr);
		sdf.setTimeZone(defaultTimeZone);
		String newDT = sdf.format(date);
		// set calendar
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(sdf.parse(newDT));
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
