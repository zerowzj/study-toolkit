package study.jdk.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.Randoms;
import study.Sleeps;

/**
 * 演示：
 */
public class Exception_loop2_Main {

    public static final Logger LOGGER = LoggerFactory.getLogger(Exception_loop2_Main.class);

    public static void main(String[] args) {
        for (; ; ) {
            try {
                int random = Randoms.nextInt(10);
                if (random == 6) {
                    LOGGER.info("random={}, throw exception", random);
                    throw new RuntimeException("");
                }
                LOGGER.info("random={}, sleep 2s", random);
                Sleeps.seconds(2);
            } catch (Exception ex) {
                LOGGER.info("SSSSSSSSSS");
            }
        }
    }
}
