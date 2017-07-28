package cz.cca.mojecca.util;

import java.util.Calendar;
import java.util.Date;
import org.joda.time.DateTimeComparator;

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

}
