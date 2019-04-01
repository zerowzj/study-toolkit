package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Randoms;
import study.Sleeps;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 演示：线程池执行器用法
 */
public class ThreadPoolExecutor1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolExecutor1_Main.class);

    public static final int T_NUM = 5;

    public static void main(String[] args) {
        //核心线程池数量
        int corePoolSize = 2;
        //最大线程池数量
        int maximumPoolSize = 2;
        //线程池中超过corePoolSize数目的空闲线程最大存活时间
        int keepAliveTime = 0;
        //阻塞任务队列
        BlockingQueue workQueue = new ArrayBlockingQueue<>(1);
        //线程创建工厂
        ThreadFactory factory = (r) -> {
            Thread t = new Thread(r);
            return t;
        };
        //当提交任务数超过maxmumPoolSize+workQueue之和时，任务会交给RejectedExecutionHandler来处理
        RejectedExecutionHandler handler = (r, executor) -> {
            LOGGER.info("discard");
        };
        ThreadPoolExecutor pool = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime, TimeUnit.SECONDS,
                workQueue,
                //factory,
                handler);
        for (int i = 0; i < T_NUM; i++) {
            int no = i + 1;
            pool.execute(() -> {
                int random = Randoms.nextInt(10);
                LOGGER.info("i am task[{}], sleep {}s", no, random);
                Sleeps.seconds(random);
                LOGGER.info("task[{}] end", no);
            });
        }
        LOGGER.info("shutdown...");
        pool.shutdown();
        LOGGER.info("main thread end");
    }
}
