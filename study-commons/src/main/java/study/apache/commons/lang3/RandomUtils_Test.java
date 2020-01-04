package study.apache.commons.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

@Slf4j
public class RandomUtils_Test {

    @Test
    public void random_test() {
        int random = RandomUtils.nextInt();
        log.info("{}", random);
    }
}
