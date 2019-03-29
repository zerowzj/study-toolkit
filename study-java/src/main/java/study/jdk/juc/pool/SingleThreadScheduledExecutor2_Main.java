package study.jdk.juc.pool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 演示：单线程调度执行器
 */
public class SingleThreadScheduledExecutor2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(SingleThreadScheduledExecutor2_Main.class);

    class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            return null;
        }
    }

    private void test() {
        ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();
        LOGGER.info("");
    }

    public static void main(String[] args) {
        new SingleThreadScheduledExecutor2_Main().test();
    }
}
