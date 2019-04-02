package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Randoms;
import study.Sleeps;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 演示：单线程调度执行器
 */
public class SingleThreadScheduledExecutor1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleThreadScheduledExecutor1_Main.class);

    private static final int TASK_NUM = 5;

    public static void main(String[] args) {
        ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
        LOGGER.info("schedule start");

        for (int i = 0; i < TASK_NUM; i++) {
            int no = i + 1;
            long delay = Randoms.nextLong(10);
            schedule.schedule(() -> {
                LOGGER.info("i am task[{}], delay {}s", no, delay);
                Sleeps.seconds(delay);
                LOGGER.info("task[{}] end", no);
            }, delay, TimeUnit.SECONDS);
        }
        LOGGER.info("schedule shutdown");
        schedule.shutdown();
        LOGGER.info("main thread end");
    }
}
