package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 演示：scheduleWithFixedDelay()，以上一个任务结束时开始计时，delay过去后，立即执行
 */
public class SingleThreadScheduledExecutor3_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleThreadScheduledExecutor3_Main.class);

    public static void main(String[] args) {
        ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
        //
        LOGGER.info("schedule start");
        long initialDelay = 0;
        long delay = 5;
        schedule.scheduleWithFixedDelay(() -> {
                    LOGGER.info("i am task");
                    Sleeps.seconds(2 * delay);
                },
                initialDelay,
                delay,
                TimeUnit.SECONDS);
        //
//        schedule.shutdown();
        LOGGER.info("main thread end");
    }
}
