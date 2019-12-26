package study.commons.lang;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

@Slf4j
public class RandomTest {

    @Test
    public void next_test() {
        System.out.println(RandomUtils.nextInt());
        System.out.println(RandomUtils.nextInt(1, 100));
    }

    //随机字母+数字+
    @Test
    public void random_test() {
        System.out.println(RandomStringUtils.random(4));
    }

    //随机字母
    @Test
    public void randomAlphabetic_test() {
        System.out.println(RandomStringUtils.randomAlphabetic(4));
    }

    //随机数
    @Test
    public void randomNumeric_test() {
        System.out.println(RandomStringUtils.randomNumeric(4));
    }

    //随机字母+数字
    @Test
    public void randomAlphanumeric_test() {
        System.out.println(RandomStringUtils.randomAlphanumeric(4));
    }
}
