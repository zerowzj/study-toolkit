package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ScheduledThreadPool_Main {

    public static final Logger LOGGER = LoggerFactory.getLogger(ScheduledThreadPool_Main.class);

    private class Task implements Runnable {
        @Override
        public void run() {
            LOGGER.info("i am doing the task");
        }
    }

    private void test() {
        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(3);
        schedule.schedule(new Task(), 2, TimeUnit.SECONDS);
        schedule.schedule(new Task(), 2, TimeUnit.SECONDS);
        schedule.schedule(new Task(), 2, TimeUnit.SECONDS);
        schedule.shutdown();
        LOGGER.info("schedule shutdown");
    }

    public static void main(String[] args) {
        new ScheduledThreadPool_Main().test();
    }
}
