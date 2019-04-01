package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 演示：拒绝策略
 */
public class ThreadPoolExecutor2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolExecutor2_Main.class);

    /**
     * 拒绝处理器
     */
    private class MyRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            LOGGER.info("sssssssss");
        }
    }

    private void test() {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));
        pool.setRejectedExecutionHandler(new MyRejectedExecutionHandler());
        for (int i = 0; i < 8; i++) {
            int index = i + 1;
            pool.execute(() -> {
                LOGGER.info("i am task[{}], sleep 10s", index);
                Sleeps.seconds(10);
                LOGGER.info("task[{}] end", index);
            });
        }
        pool.shutdown();
    }

    public static void main(String[] args) {
        new ThreadPoolExecutor2_Main().test();
    }
}
