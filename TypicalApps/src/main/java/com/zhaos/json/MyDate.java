package com.zhaos.json;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
/**
 * 自定义的类型MyDate, 只有日期没有具体的时间;
 * 
 * @author zhaosheng
 *
 */
public class MyDate extends Date implements Cloneable {

	private static final long serialVersionUID = 739048978512419876L;

	private final static long date_20000101 = 946656000000L;

	/**
	 * 
	 * Creates a new instance of RctDate.<br/>
	 * Description: Allocates a RctDate object and initializes it so that it
	 * represents the time at which it was allocated, measured to the nearest
	 * millisecond.<br/>
	 */
	public MyDate() {
		this(new Date());
	}

	/**
	 * 
	 * Creates a new instance of RctDate.<br/>
	 * Description: Allocates a RctDate object and initializes it to represent
	 * the specified number of milliseconds since the standard base time known
	 * as "the epoch", namely January 1, 1970, 00:00:00 GMT.<br/>
	 * 
	 * @param date
	 *            the specified number of milliseconds
	 * @throws ParseException
	 */
	public MyDate(long date) {
		this(new Date(date));
	}

	/**
	 * 
	 * Creates a new instance of RctDate.<br/>
	 * 
	 * @param date
	 * @throws ParseException
	 */
	public MyDate(Date date) {
		super(date.getTime());
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date d;
		try {
			d = df.parse(df.format(date));
			super.setTime(d.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * valueOf: Converts a java.util.Date escape format to a RctDate value <br/>
	 * 
	 * @param date
	 */
	public static MyDate valueOf(java.util.Date date) {
		if (date == null) {
			return null;
		}
		return new MyDate(date.getTime());
	}

	/**
	 * 
	 * valueOf: Converts a java.sql.Date escape format to a RctDate value <br/>
	 * 
	 */
	public static MyDate valueOf(java.sql.Date sqlDate) {
		if (sqlDate == null) {
			return null;
		}
		return new MyDate(sqlDate.getTime());
	}

	/**
	 * Return a copy of this object.
	 */
	public MyDate clone() {
		return (MyDate) super.clone();
	}

	/**
	 * 
	 * valueOf: Converts a formative String of "yyyy-MM-dd" to a RctDate value <br/>
	 * 
	 * @throws ParseException
	 * @throws CoreException
	 */
	public static MyDate yyyy_MM_dd(String date) {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date d = df.parse(date);
			return new MyDate(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		throw new  IllegalArgumentException("参数异常");
	}

	public static MyDate yyyyMMdd(String date)  {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		try {
			Date d = df.parse(date);
			return new MyDate(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		throw new IllegalArgumentException("参数异常");
	}

	public static MyDate ddMMMyy(String date) throws ParseException {
		if (StringUtils.isBlank(date)) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat("ddMMMyy", Locale.US);
		Date d = df.parse(date);
		if (d.getTime() < date_20000101) {
			return (new MyDate(d)).addYears(100);
		} else {
			return new MyDate(d);
		}
	}

	public static int getOffsetDay(MyDate srcDate, MyDate offsetDate) {
		if (srcDate == null || offsetDate == null) {
			throw new IllegalArgumentException("参数异常");
		}

		return (int) ((offsetDate.getTime() - srcDate.getTime()) / (24 * 60 * 60 * 1000));
	}

	/**
	 * 
	 * Formats a date in the date escape format yyyy-MM-dd. <br/>
	 * 
	 * @return yyyy-MM-dd
	 */
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(this);
	}

	/**
	 * 
	 * toyyyyMMdd:Formats a date in the date escape format yyyyMMdd. <br/>
	 * 
	 * @return yyyyMMdd <br/>
	 */
	public String toyyyyMMdd() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		return df.format(this);
	}

	public String toyyyy_MM_dd() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(this);
	}

	/**
	 * 
	 * 
	 * @exception <br>
	 * @return <br>
	 */
	public Date toDate() {
		return (Date) this;
	}

	/**
	 * 
	 * @exception <br>
	 * @return <br>
	 */
	public java.sql.Date toSqlDate() {
		return new java.sql.Date(this.getTime());
	}

	/**
	 * 
	 * toddMMMyy:Formats a date in the date escape format ddMMMyy<br>
	 * 
	 * @return ddMMMyy <br>
	 */
	public String toddMMMyy() {
		SimpleDateFormat df = new SimpleDateFormat("ddMMMyy", Locale.US);
		return df.format(this).toUpperCase();
	}

	/**
     * 
     */
	public int countDateInterval(MyDate date) {
		if (date == null) {
			throw new IllegalArgumentException("参数异常");
		}
		return (int) Math.abs((this.getTime() - date.getTime())
				/ (24 * 60 * 60 * 1000));
	}

	public MyDate addDays(int dayNum) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(this);
		cd.add(Calendar.DATE, dayNum);
		return MyDate.valueOf(cd.getTime());
	}

	public static MyDate addDays(Date date, int dayNum) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(date);
		cd.add(Calendar.DATE, dayNum);
		return MyDate.valueOf(cd.getTime());
	}

	public MyDate addYears(int yearNum) {
		return MyDate.addYears(this, yearNum);
	}

	public static MyDate addYears(Date date, int yearNum) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(date);
		cd.add(Calendar.YEAR, yearNum);
		return MyDate.valueOf(cd.getTime());
	}

	public static long countTimespanMinute(Date startDate, Date endDate) {
		return (endDate.getTime() - startDate.getTime()) / 1000 / 60;
	}

	public int getWeekDayOfChina() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this);
		int weekday_west = cal.get(Calendar.DAY_OF_WEEK);
		int weekday_china = (weekday_west == 1) ? 7 : (weekday_west - 1);
		return weekday_china;
	}

	public static int getWeekDayOfChina(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int weekday_west = cal.get(Calendar.DAY_OF_WEEK);
		int weekday_china = (weekday_west == 1) ? 7 : (weekday_west - 1);
		return weekday_china;
	}

	/**
     * 
     */
	public static List<MyDate> splitDate2SingleDay(MyDate startDate,
			MyDate endDate, String frequency) {
		List<MyDate> days = new ArrayList<MyDate>();
		Calendar end = Calendar.getInstance();
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		end.setTime(endDate);
		end.add(Calendar.DAY_OF_MONTH, 1);
		while (start.before(end)) {
			int weekday_west = start.get(Calendar.DAY_OF_WEEK);
			int weekday_china = (weekday_west == 1) ? 7 : (weekday_west - 1);
			Pattern p = Pattern.compile(String.valueOf(weekday_china));
			Matcher m = p.matcher(frequency);
			if (m.find()) {
				days.add(MyDate.valueOf(start.getTime()));
			}
			start.add(Calendar.DAY_OF_MONTH, 1);
		}
		return days;
	}

	/**
     * 
     */
	public static MyDate calculateRctDate(MyDate date, long offset) {
		return new MyDate(date.getTime() + offset);
	}

	/**
	 * 
	 * Get the earliest date of which week day appears in freqStr .<br/>
	 * 
	 * @param startDate
	 *            : Not null, or else throw NullPointerException.
	 * @param endDate
	 *            : Not null, or else, throw NullPointerException.
	 * @param freqStr
	 *            : Not null and be legal, from "1234567". If null, throw
	 *            NullPointerException.
	 * @return
	 */
	public static MyDate getNearestStartDay(MyDate startDate, MyDate endDate,
			String freqStr) {
		MyDate date = startDate;
		while (date.compareTo(endDate) <= 0) {
			boolean bFirst = freqStr.contains(String.valueOf(date
					.getWeekDayOfChina()));
			if (bFirst) {
				return date;
			}
			date = date.addDays(1);
		}
		return null;
	}

	/**
	 * 
	 * Get the latest date of which week day appears in freqStr .<br/>
	 * 
	 * @param startDate
	 *            : Not null锛宱r else throw NullPointerException.
	 * @param endDate
	 *            : Not null, or else throw NullPointerException.
	 * @param freqStr
	 *            : Not null and be legal, from "1234567". If null, throw
	 *            NullPointerException.
	 * @return
	 */
	public static MyDate getNearestEndDay(MyDate startDate, MyDate endDate,
			String freqStr) {
		MyDate date = endDate;
		while (date.compareTo(startDate) >= 0) {
			boolean bFirst = freqStr.contains(String.valueOf(date
					.getWeekDayOfChina()));
			if (bFirst) {
				return date;
			}
			date = date.addDays(-1);
		}
		return null;
	}
}
