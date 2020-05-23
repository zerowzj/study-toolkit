package study.jodatime.utils;

import org.joda.time.DateTime;

import java.util.Date;

public class DateUtils {

    /**
     * 获取当前时间
     */
    public static Date now() {
        return DateTime.now().toDate();
    }

    /**
     * 转换字符串
     */
    public static String toStdDateStr(Date date) {
        return toStr(date, DateFormat.STD_DATE);
    }

    public static String toStdDateTimeStr(Date date) {
        return toStr(date, DateFormat.STD_DATE_TIME);
    }

    public static String toStdDateTimeMsStr(Date date) {
        return toStr(date, DateFormat.STD_DATE_TIME_MS);
    }

    public static String toStr(Date date, DateFormat format) {
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(format.getValue());
    }

    /**
     * 时间计算
     */
    public static Date plusMinutes(int minutes) {
        return plusMinutes(DateTime.now().toDate(), minutes);
    }

    public static Date plusMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        DateTime dt = dateTime.plusMinutes(minutes);
        return dt.toDate();
    }

    public static Date plusHours(int hours) {
        return plusHours(DateTime.now().toDate(), hours);
    }

    public static Date plusHours(Date date, int hours) {
        DateTime dateTime = new DateTime(date);
        DateTime dt = dateTime.plusHours(hours);
        return dt.toDate();
    }
}
