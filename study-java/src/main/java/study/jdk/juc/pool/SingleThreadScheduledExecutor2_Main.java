package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * 演示：有返回值的单线程调度执行器
 */
public class SingleThreadScheduledExecutor2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleThreadScheduledExecutor2_Main.class);

    private class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "sssssssssssss";
        }
    }

    private void test() {
        ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();

        LOGGER.info("schedule start");
        long delay = 5;
        ScheduledFuture<String> future = schedule.schedule(new Task(),
                delay,
                TimeUnit.SECONDS);
        try {
            //阻塞调用线程
            String data = future.get();
            LOGGER.info("data={}", data);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }

        LOGGER.info("schedule shutdown");
        schedule.shutdown();
        LOGGER.info("main thread end");

    }

    public static void main(String[] args) {
        new SingleThreadScheduledExecutor2_Main().test();
    }
}
