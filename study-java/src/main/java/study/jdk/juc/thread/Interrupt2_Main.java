package study.jdk.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Sleeps;

import java.util.concurrent.TimeUnit;

/**
 * 中断
 */
public class Interrupt2_Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Interrupt2_Main.class);

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            //
//            while (true) {
//                //LOGGER.info("loop");
//            }
            //
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        t.start();

        Sleeps.seconds(2);
        LOGGER.info("isInterrupted= {}", t.isInterrupted());
        t.interrupt();
        LOGGER.info("isInterrupted= {}", t.isInterrupted());
    }
}