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
     * 任务
     */
    private class Task implements Runnable {

        private String taskNo;

        public Task(String taskNo) {
            this.taskNo = taskNo;
        }

        @Override
        public void run() {
            LOGGER.info("i am task[{}], sleep 10s", taskNo);
            Sleeps.seconds(10);
            LOGGER.info("task[{}] end", taskNo);
        }

        public String getTaskNo() {
            return this.taskNo;
        }
    }

    /**
     * 拒绝处理器
     */
    private class MyRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            LOGGER.info("task[{}] rejected", ((Task) r).getTaskNo());
            executor.getActiveCount();
            executor.getCompletedTaskCount();
            executor.getTaskCount();
        }
    }

    private void test() {
        RejectedExecutionHandler handler = new MyRejectedExecutionHandler();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 2, 0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                handler);
        for (int i = 0; i < 8; i++) {
            int no = i + 1;
            pool.execute(new Task(String.valueOf(no)));
        }
        pool.shutdown();
    }

    public static void main(String[] args) {
        new ThreadPoolExecutor2_Main().test();
    }
}
