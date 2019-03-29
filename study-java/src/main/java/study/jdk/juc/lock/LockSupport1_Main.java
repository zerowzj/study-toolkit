package study.jdk.juc.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.LockSupport;

public class LockSupport1_Main {

    public static final Logger LOGGER = LoggerFactory.getLogger(LockSupport1_Main.class);

    public static void main(String[] args) {
        LOGGER.info("begin park!");

        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();

        LOGGER.info("end park!");
    }
}
