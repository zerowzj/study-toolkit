package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 演示：
 * （1）Fixed-Rate，固定频率
 * （2）以上一个任务开始的时间计时，period过去后，
 * 检测上一个任务是否执行完毕，如果上一个任务执行完毕，则当前任务立即执行，
 * 如果上一个任务没有执行完毕，则需要等上一个任务执行完毕后立即执行
 */
public class SingleThreadScheduledExecutor4_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleThreadScheduledExecutor4_Main.class);

    private class Task implements Runnable {
        @Override
        public void run() {
            LOGGER.info("i am doing the task");
        }
    }

    private void test() {
        ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
        LOGGER.info("schedule start");

        long initialDelay = 0;
        long period = 5;
        schedule.scheduleAtFixedRate(new Task(),
                initialDelay,
                period, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        new SingleThreadScheduledExecutor4_Main().test();
    }
}
