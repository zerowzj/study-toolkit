package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示：单线程执行器用法
 */
public class SingleThreadExecutor_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleThreadExecutor_Main.class);

    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            pool.execute(() -> {
                LOGGER.info("i am thread[{}]", j + 1);
                Sleeps.seconds(20000);
            });
        }
        pool.shutdown();
    }
}
