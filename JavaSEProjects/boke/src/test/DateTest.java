package test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author menglanyingfei
 * @date 2017-9-2
 */
public class DateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Date date = new Date();
		Calendar calendar = GregorianCalendar.getInstance(); 
		calendar.setTime(date);  
		int hours = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
		System.out.println(hours);
	}

}
