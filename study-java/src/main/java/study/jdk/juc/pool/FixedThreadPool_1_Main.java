package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Randoms;
import study.Sleeps;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示：固定线程池
 */
public class FixedThreadPool_1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(FixedThreadPool_1_Main.class);

    private static final int THREAD_NUM = 3;

    private static final int TASK_NUM = 5;

    /**
     * 线程工厂
     */
    private class MyThreadFactory implements ThreadFactory {

        private AtomicInteger tnum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "pool-thread-" + tnum.getAndIncrement());
            return t;
        }
    }

    private void test() {
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUM, new MyThreadFactory());
        //线程池pool执行
        for (int i = 0; i < TASK_NUM; i++) {
            int no = i + 1;
            pool.execute(() -> {
                int random = Randoms.nextInt(10);
                LOGGER.info("i am task [{}], sleep {}s", no, random);
                Sleeps.seconds(random);
                LOGGER.info("task [{}] finish", no);
            });
        }
        //
        LOGGER.info("i am thread main");
        pool.shutdown();
        LOGGER.info("main thread end");
    }

    public static void main(String[] args) {
        new FixedThreadPool_1_Main().test();
    }
}
