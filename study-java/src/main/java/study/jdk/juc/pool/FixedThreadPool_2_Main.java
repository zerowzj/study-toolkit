package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示：
 */
public class FixedThreadPool_2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(FixedThreadPool_2_Main.class);

    /**
     * 线程执行单元
     */
    private class Task implements Runnable {

        private int no;

        @Override
        public void run() {
            LOGGER.info("ssssssssssss");
        }
    }

    /**
     * 线程工厂
     */
    private class MyThreadFactory implements ThreadFactory {

        private AtomicInteger tnum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "poo-thread-" + tnum.getAndIncrement());
        }
    }

    private void test() {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Task task = new Task();
        //线程池pool执行
        for (int i = 0; i < 5; i++) {
            pool.execute(task);
        }
        pool.shutdown();
    }

    public static void main(String[] args) {
        new FixedThreadPool_2_Main().test();
    }
}
