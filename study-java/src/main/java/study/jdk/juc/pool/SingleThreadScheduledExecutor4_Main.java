package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 演示：单线程调度执行器
 */
public class SingleThreadScheduledExecutor4_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleThreadScheduledExecutor4_Main.class);

    private class Task implements Runnable {
        @Override
        public void run() {
            LOGGER.info("i am doing the task");
        }
    }

    private void test() {
        ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
        LOGGER.info("schedule start");
        long initialDelay = 0;
        long delay = 5;
        schedule.scheduleAtFixedRate(new Task(), initialDelay, delay, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        new SingleThreadScheduledExecutor4_Main().test();
    }
}
