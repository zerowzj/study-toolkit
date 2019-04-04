package study.jdk.juc.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 演示：
 * （1）
 * （2）
 * （3）
 */
public class AQS1_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(AQS1_Main.class);

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Mutex lock = new Mutex();
        for (int i = 0; i < 3; i++) {
            int taskNo = i + 1;
            pool.execute(() -> {
//                lock.lock();
                try {
                    LOGGER.info("i am task[{}]", taskNo);
                    Sleeps.seconds(5);
                } finally {
//                    lock.unlock();
                }
            });
        }
        pool.shutdown();
        LOGGER.info("main thread end");
    }
}
