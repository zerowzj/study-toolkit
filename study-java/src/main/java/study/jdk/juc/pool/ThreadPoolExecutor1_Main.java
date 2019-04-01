package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Randoms;
import study.Sleeps;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 演示：基本用法
 */
public class ThreadPoolExecutor1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolExecutor1_Main.class);

    public static void main(String[] args) {
        //核心线程数大小
        int corePoolSize = 5;
        //最大线程数大小
        int maximumPoolSize = 5;
        //存活时间
        int keepAliveTime = 0;
        //工作队列
        BlockingQueue workQueue = new ArrayBlockingQueue<>(1);

        ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime, TimeUnit.SECONDS,
                workQueue);
        for (int i = 0; i < 5; i++) {
            int index = i + 1;
            pool.execute(() -> {
                int random = Randoms.nextInt(10);
                LOGGER.info("i am task[{}], sleep {}s", index, random);
                Sleeps.seconds(random);
                LOGGER.info("task[{}] end", index);
            });
        }
        LOGGER.info("");
        pool.shutdown();
        LOGGER.info("main thread end");
    }
}
