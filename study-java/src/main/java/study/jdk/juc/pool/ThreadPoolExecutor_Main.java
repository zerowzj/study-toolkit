package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 演示：
 */
public class ThreadPoolExecutor_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolExecutor_Main.class);

    public static void main(String[] args) {
        //线程池是重量级对象，谨慎创建，尽量复用
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        for (int i = 0; i < 5; i++) {
            final int j = i;
            pool.execute(() -> {
                if (j / 2 == 0) {
                    Sleeps.seconds(5);
                }
                LOGGER.info("i am thread[{}]", j + 1);
            });
        }
        //pool.shutdown();
    }
}
