package study.jodatime.utils;

import lombok.Getter;

@Getter
public enum DateFormat {
    //扁平格式
    FLAT_DATE("yyyy-MM-dd"),
    //简单的
    SIMPLE_DATE(""),

    //标准格式
    STD_DATE("yyyy-MM-dd"),
    STD_DATE_TIME("yyyy-MM-dd HH:mm:ss"),
    STD_DATE_TIME_MS("yyyy-MM-dd HH:mm:ss.SSS"),
    //短格式
    SHORT_DATE("yyyyMMdd"),
    SHORT_DATE_TIME("yyyyMMddHHmmss"),
    SHORT_DATE_TIME_MS("yyyyMMddHHmmssSSS");

    String value;

    DateFormat(String value) {
        this.value = value;
    }
}
