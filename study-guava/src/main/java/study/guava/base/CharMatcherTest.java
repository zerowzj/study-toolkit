package study.guava.base;

import com.google.common.base.CharMatcher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class CharMatcherTest {

    @Test
    public void digit_test() {
        String str = "3a";
        boolean b = CharMatcher.digit().matchesAllOf(str);
        log.info("{}", b);

        b = CharMatcher.digit().matchesAnyOf(str);
        log.info("{}", b);

        b = CharMatcher.digit().matchesNoneOf(str);
        log.info("{}", b);
    }

    @Test
    public void javaDigit_test() {
        String str = "1212---";
        boolean b = CharMatcher.javaDigit().matchesAllOf(str);
        log.info("{}", b);
    }
}
