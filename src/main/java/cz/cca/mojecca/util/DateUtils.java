package cz.cca.mojecca.util;

import java.util.Calendar;
import java.util.Date;
import org.joda.time.DateTimeComparator;
import org.joda.time.LocalDate;

public class DateUtils {
	
	public static Date cutTime(Date date) {
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	public static boolean isToday(Date date) {
		return DateTimeComparator.getDateOnlyInstance().compare(date, new Date()) == 0;
	}
	
	public static Date firstDayOfYear(int year) {
		return new LocalDate().withYear(year).withMonthOfYear(1).withDayOfMonth(1).toDate();
	}
	
	public static Date lastDayOfYear(int year) {
		return new LocalDate().withYear(year).withMonthOfYear(12).withDayOfMonth(31).toDate();
	}
	
	public static Date firstDayOfCurrentYear() {
		return firstDayOfYear(new LocalDate().getYear());
	}
	
	public static Date lastDayOfCurrentYear() {
		return lastDayOfYear(new LocalDate().getYear());
	}
	

}
