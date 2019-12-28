package study.commons.collections4.list;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

import java.util.List;

@Slf4j
public class ListUtilsTest {

    @Test
    public void emptyIfNull_test() {
        List<String> lt = null;
        List<String> newLt = ListUtils.emptyIfNull(lt);
        newLt.forEach(str -> {
            log.info(str);
        });
    }

    @Test
    public void test() {
    }
}
