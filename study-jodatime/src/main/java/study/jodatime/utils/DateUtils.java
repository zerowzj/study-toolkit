package study.jodatime.utils;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

@Slf4j
public class DateUtils {

    @Getter
    public enum DateFormat {
        //扁平格式
        FLAT_DT("yyyy-MM-dd"),
        //简单的
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

        DateFormat(String value) {
            this.value = value;
        }
    }

    /**
     * 获取当前时间
     */
    public static Date now() {
        return DateTime.now().toDate();
    }

    /**
     * 转换成字符串
     */
    public static String toStdDtStr(Date date) {
        return toStr(date, DateFormat.STD_DT);
    }

    public static String toStdDtTimeStr(Date date) {
        return toStr(date, DateFormat.STD_DT_TIME);
    }

    public static String toStdDtTimeMsStr(Date date) {
        return toStr(date, DateFormat.STD_DT_TIME_MS);
    }

    public static String toStr(Date date, DateFormat format) {
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(format.getValue());
    }

    /**
     * 转换成日期
     */
    public static Date toDate(String str, DateFormat dateFormat) {
        DateTimeFormatter fmt = DateTimeFormat.forPattern(dateFormat.getValue());
        return DateTime.parse(str, fmt).toDate();
    }

    /**
     * 分钟计算
     */
    public static Date plusMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        DateTime dt = dateTime.plusMinutes(minutes);
        return dt.toDate();
    }

    /**
     * 小时计算
     */
    public static Date plusHours(Date date, int hours) {
        DateTime dateTime = new DateTime(date);
        DateTime dt = dateTime.plusHours(hours);
        return dt.toDate();
    }

    /**
     * 天计算
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
        DateTime nowTime = new DateTime(date);
        DateTime startOfDay = nowTime.withTimeAtStartOfDay();
        log.info(startOfDay.toString(DateFormat.STD_DT_TIME_MS.getValue()));
        return startOfDay.toDate();
    }

    /**
     * 获取指定日期的结束时间
     * 比如：2014-06-19 23:59:59
     */
    public static Date getEndOfDay(Date date) {
        DateTime nowTime = new DateTime(date);
        DateTime endOfDay = nowTime.millisOfDay().withMaximumValue();
        log.info(endOfDay.toString(DateFormat.STD_DT_TIME_MS.getValue()));
        return endOfDay.toDate();
    }

    public static void main(String[] args) {
        getStartOfDay(new Date());
        getEndOfDay(new Date());

    }
}
