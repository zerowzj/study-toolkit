package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示：
 * （1）单线程执行器
 * （2）主线程结束，线程池线程可能还在运行
 * （3）任务和线程是2个概念
 */
public class SingleThreadExecutor_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleThreadExecutor_Main.class);

    private static final int TASK_NUM = 5;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < TASK_NUM; i++) {
            int taskNo = i + 1;
            pool.execute(() -> {
                LOGGER.info("i am task[{}], sleep 2s", taskNo);
                Sleeps.seconds(2);
            });
        }
        LOGGER.info("i am main thread");
        pool.shutdown();
        LOGGER.info("main thread end");
    }
}
