package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定线程池
 */
public class FixedThreadPool_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(FixedThreadPool_Main.class);

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            final int j = i;
            pool.execute(() -> {
                LOGGER.info("thread[{}] sleep start", j + 1);
                Sleeps.seconds(50000);
                LOGGER.info("thread[{}] sleep start", j + 1);
            });
        }
        pool.shutdown();
    }
}
