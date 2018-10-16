package study.jdk.concurrent.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutor_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolExecutor_Main.class);

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        for (int i = 0; i < 5; i++) {
            final int j = i;
            pool.execute(() -> {
                LOGGER.info("i am thread[{}]", j + 1);
            });
        }
        //TODO 线程池是重量级对象
        pool.shutdown();
    }
}
