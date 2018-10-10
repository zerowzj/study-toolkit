package study;

import java.util.concurrent.TimeUnit;

public class Sleeps {

    public static void seconds(long timeout){
        try {
            TimeUnit.SECONDS.sleep(timeout);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void minutes(long timeout){
        try {
            TimeUnit.MINUTES.sleep(timeout);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void milliseconds(long timeout){
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
