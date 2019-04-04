package study.jdk.juc.aqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示：
 * （1）
 */
public class CAS2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(CAS2_Main.class);

    private static final int THREAD_NUM = 10000;

    private AtomicInteger casI = new AtomicInteger(0);



    private void test_cas() {
        ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUM);
        for (int i = 0; i < THREAD_NUM; i++) {
            pool.execute(() -> {

            });
        }

    }

    private void test_synch() {

    }


    public static void main(String[] args) {
    }
}
