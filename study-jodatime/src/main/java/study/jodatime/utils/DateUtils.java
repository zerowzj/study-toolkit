package study.jodatime.utils;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.util.Date;

@Slf4j
public class DateUtils {

    @Getter
    public enum DateFmt {
        //扁平格式
        FLAT_DT("yyyy-MM-dd"),
        //简单
        SIMPLE_DT(""),



        //标准格式
        STD_DT("yyyy-MM-dd"),
        STD_DT_TIME("yyyy-MM-dd HH:mm:ss"),
        STD_DT_TIME_MS("yyyy-MM-dd HH:mm:ss.SSS"),
        //短格式
        SHORT_DT("yyyyMMdd"),
        SHORT_DT_TIME("yyyyMMddHHmmss"),
        SHORT_DT_TIME_MS("yyyyMMddHHmmssSSS");

        String value;

        DateFmt(String value) {
            this.value = value;
        }
    }

    /**
     * ===================
     * 获取当前时间
     * ====================
     */
    public static Date now() {
        return DateTime.now().toDate();
    }

    public static Date now(boolean millis) {
        DateTime now = DateTime.now()
                .withMillisOfSecond(0);
        return now.toDate();
    }

    public static long currentTimeMillis() {
        return DateTime.now().getMillis();
    }

    /**
     * ===================
     * 转换成字符串
     * ====================
     */
    public static String toStr(Date date, DateFmt format) {
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(format.getValue());
    }

    public static String toStdDtStr(Date date) {
        return toStr(date, DateFmt.STD_DT);
    }

    public static String toStdDtTimeStr(Date date) {
        return toStr(date, DateFmt.STD_DT_TIME);
    }

    public static String toStdDtTimeMsStr(Date date) {
        return toStr(date, DateFmt.STD_DT_TIME_MS);
    }

    /**
     * ===================
     * 转换成日期
     * ====================
     */
    public static Date toDate(String str, DateFmt dateFormat) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern(dateFormat.getValue());
        return DateTime.parse(str, fmt).toDate();
    }

    /**
     * 按分钟计算
     */
    public static Date plusMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        DateTime dt = dateTime.plusMinutes(minutes);
        return dt.toDate();
    }

    /**
     * 按小时计算
     */
    public static Date plusHours(Date date, int hours) {
        DateTime dateTime = new DateTime(date);
        DateTime dt = dateTime.plusHours(hours);
        return dt.toDate();
    }

    /**
     * 按天计算
     */
    public static Date plusDays(Date date, int days) {
        DateTime dateTime = new DateTime(date);
        DateTime dt = dateTime.plusDays(days);
        return dt.toDate();
    }

    /**
     * 按月计算
     */
    public static Date plusMonths(Date date, int months) {
        DateTime dateTime = new DateTime(date);
        DateTime dt = dateTime.plusMonths(months);
        return dt.toDate();
    }

    /**
     * 获取指定日期的开始时间
     * 比如：2014-06-19 00:00:00
     */
    public static Date getStartOfDay(Date date) {
        DateTime dateTime = new DateTime(date);
        DateTime startOfDay = dateTime.millisOfDay()
                .withMinimumValue();
        return startOfDay.toDate();
    }

    /**
     * 获取指定日期的结束时间
     * 比如：2014-06-19 23:59:59
     */
    public static Date getEndOfDay(Date date) {
        DateTime dateTime = new DateTime(date);
        DateTime endOfDay = dateTime.millisOfDay()
                .withMaximumValue();
        return endOfDay.toDate();
    }

    @Test
    public void test() {
        log.info(toStdDtTimeMsStr(now()));
//        log.info(toStdDtTimeMsStr(getStartOfDay(new Date())));
//        log.info(toStdDtTimeMsStr(getEndOfDay(new Date())));
    }
}
