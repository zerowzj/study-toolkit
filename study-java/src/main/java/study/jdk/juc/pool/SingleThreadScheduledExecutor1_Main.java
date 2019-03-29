package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 演示：单线程调度执行器
 */
public class SingleThreadScheduledExecutor1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleThreadScheduledExecutor1_Main.class);

    class Task implements Runnable {
        @Override
        public void run() {
            LOGGER.info("i am doing the task");
        }
    }

    private void test() {
        ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
        LOGGER.info("schedule start");
        /**
         * command
         * delay
         * unit
         */
        //
//        schedule.schedule(new Task(), 5, TimeUnit.SECONDS);
//        schedule.shutdown();
//        LOGGER.info("schedule shutdown");
        /**
         * command
         * initialDelay
         * period
         * unit
         */
//        schedule.scheduleAtFixedRate(new Task(), 0, 5, TimeUnit.SECONDS);
        /**
         * command
         * initialDelay
         * delay
         * unit
         */
        schedule.scheduleWithFixedDelay(new Task(), 0, 5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        new SingleThreadScheduledExecutor1_Main().test();
    }
}
