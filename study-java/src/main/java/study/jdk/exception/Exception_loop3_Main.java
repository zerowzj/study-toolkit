package study.jdk.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Randoms;
import study.Sleeps;

/**
 * 演示：循环体内捕获异常，循环继续
 */
public class Exception_loop3_Main {

    public static final Logger LOGGER = LoggerFactory.getLogger(Exception_loop3_Main.class);

    public static void main(String[] args) {
        for (; ; ) {
            try {
                int random = Randoms.nextInt(10);
                if (random == 0) {
                    throw new RuntimeException("random is 0");
                }
                LOGGER.info("random={}, sleep 2s", random);
                Sleeps.seconds(2);
            } catch (Exception ex) {
                LOGGER.info("loop exception");
            }
        }
    }
}
