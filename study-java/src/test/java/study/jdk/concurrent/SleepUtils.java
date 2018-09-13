package study.jdk.concurrent;

import java.util.concurrent.TimeUnit;

public class SleepUtils {

    public static void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception ex) {

        }
    }

    public static void milliseconds(long milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (Exception ex) {

        }
    }
}
