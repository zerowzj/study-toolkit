package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 演示：固定延迟
 */
public class SingleThreadScheduledExecutor3_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleThreadScheduledExecutor3_Main.class);

    public static void main(String[] args) {
        ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
        //
        long initialDelay = 2;
        long delay = 5;
        LOGGER.info("schedule start");
        schedule.scheduleWithFixedDelay(() -> {
            LOGGER.info("i am task");
        }, initialDelay, delay, TimeUnit.SECONDS);

        //
//        schedule.shutdown();
        LOGGER.info("main thread end");
    }
}
