package study.guava.base;

import com.google.common.base.CharMatcher;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharMatcher_Test {

    private static final Logger LOGGER = LoggerFactory.getLogger(CharMatcher_Test.class);

    @Test
    public void digit_test() {
        String str = "";
        boolean b = CharMatcher.digit().matchesAllOf(str);
        LOGGER.info("{}", b);
    }

    @Test
    public void javaDigit_test() {
        String str = "1212---";
        boolean b = CharMatcher.javaDigit().matchesAllOf(str);
        LOGGER.info("{}", b);
    }
}
