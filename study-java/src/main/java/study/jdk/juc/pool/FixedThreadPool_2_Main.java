package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示：
 */
public class FixedThreadPool_2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(FixedThreadPool_2_Main.class);

    private Set set = new HashSet();

    /**
     * 线程执行单元
     */
    private class Task implements Runnable {

        private int no;

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                int n = ++no;
                set.add(n);
                LOGGER.info("当前号：{}", n);
            }
        }
    }

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
        ExecutorService pool = Executors.newFixedThreadPool(3, new MyThreadFactory());
        Task task = new Task();
        //线程池pool执行
        for (int i = 0; i < 3; i++) {
            pool.execute(task);
        }
        LOGGER.info("===> {}", set.size());
        pool.shutdown();
    }

    public static void main(String[] args) {
        new FixedThreadPool_2_Main().test();
    }
}
