package study.jdk.concurrent;

import java.util.concurrent.TimeUnit;

public class SleepUtils {

    public static void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception ex) {

        }
    }
}
