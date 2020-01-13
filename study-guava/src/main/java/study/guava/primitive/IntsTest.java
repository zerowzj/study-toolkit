package study.guava.primitive;

import com.google.common.primitives.Ints;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

@Slf4j
public class IntsTest {

    @Test
    public void tryParse_test() {
        String str = "0001";
        int i = Ints.tryParse(str);
        log.info("i={}", i);
    }

    @Test
    public void asList_test() {
        List<Integer> iLt = Ints.asList(1, 2, 3, 4);
        log.info("i={}", iLt);
    }

    @Test
    public void test() {
        List<Integer> iLt = Ints.asList(1, 2, 3, 4);
        log.info("i={}", iLt);
    }
}
