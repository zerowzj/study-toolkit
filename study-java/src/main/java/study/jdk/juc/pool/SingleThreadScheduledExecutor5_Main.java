package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Randoms;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 演示：异常对计划任务影响，try{}catch{}
 */
public class SingleThreadScheduledExecutor5_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleThreadScheduledExecutor5_Main.class);

    public static void main(String[] args) {
        ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
        long initialDelay = 0;
        long period = 2;
        schedule.scheduleAtFixedRate(() -> {
                    try {
                        int random = Randoms.nextInt(9);
                        if (random == 0) {
                            throw new RuntimeException("random is zero");
                        }
                        LOGGER.info("i am task, random={}", random);
                    } catch (Exception ex) {
//                        ex.printStackTrace();
                        LOGGER.info("", ex);
                    }
                },
                initialDelay,
                period, TimeUnit.SECONDS);
    }
}
