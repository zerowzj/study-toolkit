package study.commons.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

@Slf4j
public class RandomStringUtils_Test {

    /**
     *
     */
    @Test
    public void random_test() {
        String random = RandomStringUtils.random(4, true, true);
        log.info(random);
    }

    /**
     * ==========
     * 字母
     * ==========
     */
    @Test
    public void randomAlphabetic_test() {
        String random = RandomStringUtils.randomAlphabetic(4);
        log.info(random);
    }

    /**
     * ==========
     * 数字
     * ==========
     */
    @Test
    public void randomNumeric_test() {
        String random = RandomStringUtils.randomNumeric(6);
        log.info(random);
    }

    /**
     * ==========
     * 字母+数字
     * ==========
     */
    @Test
    public void randomAlphanumeric_test() {
        String random = RandomStringUtils.randomAlphanumeric(8);
        log.info(random);
    }

    /**
     *
     */
    @Test
    public void randomAscii_test() {
        String random = RandomStringUtils.randomAscii(4);
        log.info(random);
    }

    /**
     *
     */
    @Test
    public void randomGraph_test() {
        String random = RandomStringUtils.randomGraph(4);
        log.info(random);
    }

    /**
     *
     */
    @Test
    public void randomPrint_test() {
        String random = RandomStringUtils.randomPrint(4);
        log.info(random);
    }
}
