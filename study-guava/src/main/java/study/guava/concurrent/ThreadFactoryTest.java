package study.guava.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadFactoryTest {

    private static ThreadFactory threadFactory = new ThreadFactoryBuilder()
            .setNameFormat("pool-test-thread-%d")
            .build();

    private static ThreadPoolExecutor POOL = new ThreadPoolExecutor(5, 5, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), threadFactory);

    public static void main(String[] args) {
        int task_num = 5;
        for (int i = 0; i < task_num; i++) {
            POOL.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (Exception ex) {

                }
                log.info("dsfasdf");
            });
        }
        log.info("aaaa");
        POOL.shutdown();
        log.info("bbbb");
    }
}
