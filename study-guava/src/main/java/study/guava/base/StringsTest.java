package study.guava.base;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class StringsTest {

    @Test
    public void emptyToNull_test() {
        String str = "";
        str = Strings.emptyToNull(str);
        log.info("[{}]", str);
    }

    @Test
    public void nullToEmpty_test() {
        String str = null;
        log.info("[{}]", str);
        str = Strings.nullToEmpty(str);
        log.info("[{}]", str);
    }

    @Test
    public void isNullOrEmpty_test() {
        String str = "   ";
        boolean flg = Strings.isNullOrEmpty(str);
        log.info("{}", flg);
    }
    @Test
    public void test() {

    }
}
