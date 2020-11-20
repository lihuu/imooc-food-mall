package com.imooc.utils;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 日期处理
 *
 * @author lihu
 */
public class DateUtils {

    public static final String ISO_DATE_FORMAT = "yyyyMMdd";
    public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";
    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm";
    public static final DateFormatSymbols dateFormatSymbles;
    public static final int ONE_SECOND = 1000;
    public static final int ONE_MINUTE = 60 * ONE_SECOND;
    public static final int ONE_HOUR = 60 * ONE_MINUTE;
    public static final long ONE_DAY = 24 * ONE_HOUR;
    private static final String[][] foo;

    static {
        foo = new String[0][];
        dateFormatSymbles = new DateFormatSymbols();
        dateFormatSymbles.setZoneStrings(foo);
    }

    /**
     * Date Arithmetic function.
     * Adds the specified (signed) amount of tim
     * to the given time field,
     * based on the GregorianCalendar's rules.
     *
     * @param isoString
     * @param field
     * @param amount
     * @param expanded  use formating char's
     * @return ISO 8601 Date String
     * @throws ParseException
     */
    public static String add(String isoString, int field, int amount, boolean expanded) throws ParseException {
        Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTime(isoToDate(isoString, expanded));
        cal.add(field, amount);

        return dateToISO(cal.getTime(), expanded);
    }

    /**
     * Date Arithmetic function.
     * Adds the specified (signed) amount of time to the given time field,
     * based on the GregorianCalendar's rules.
     * no formating char's
     *
     * @param isoString
     * @param field
     * @param amount
     * @return ISO 8601 Date String
     * @throws ParseException
     */
    public static String add(String isoString, int field, int amount) {
        try {
            return add(isoString, field, amount, false);
        } catch (ParseException pe) {

        }
        return "";
    }

    /**
     * Return an ISO date string
     *
     * @param date
     * @param expanded use formating char's
     * @return ISO date String
     */
    public static String dateToISO(Date date, boolean expanded) {
        SimpleDateFormat formatter;

        if (expanded) {
            formatter = new SimpleDateFormat(ISO_EXPANDED_DATE_FORMAT, dateFormatSymbles);
        } else {
            formatter = new SimpleDateFormat(ISO_DATE_FORMAT, dateFormatSymbles);
        }

        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

        return formatter.format(date);
    }

    public static String getStandardFormat(Date date) {
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat(STANDARD_FORMAT);
        return formatter.format(date);
    }

    /**
     * Return an ISO date string as a java.util.Date
     *
     * @param dateString
     * @param expanded   use formating charaters
     * @return java.util.Date from the ISO Date in GMT
     * @throws ParseException
     */
    public static Date isoToDate(String dateString, boolean expanded) throws ParseException {
        SimpleDateFormat formatter;

        if (expanded) {
            formatter = new SimpleDateFormat(ISO_EXPANDED_DATE_FORMAT, dateFormatSymbles);
        } else {
            formatter = new SimpleDateFormat(ISO_DATE_FORMAT, dateFormatSymbles);
        }

        formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

        return new Date(formatter.parse(dateString).getTime());
    }

}

