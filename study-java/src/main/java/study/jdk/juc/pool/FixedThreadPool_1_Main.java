package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Randoms;
import study.Sleeps;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示：固定线程池
 */
public class FixedThreadPool_1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(FixedThreadPool_1_Main.class);

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        //执行单元（任务）
        Runnable task = () -> {
            int random = Randoms.nextInt(10);
            LOGGER.info("i am thread [{}], sleep {}s", Thread.currentThread().getName(), random);
            Sleeps.seconds(random);
            LOGGER.info("thread [{}] sleep end", Thread.currentThread().getName());
        };
        //线程池pool执行
        for (int i = 0; i < 5; i++) {
            pool.execute(task);
        }
        pool.shutdown();
    }
}
