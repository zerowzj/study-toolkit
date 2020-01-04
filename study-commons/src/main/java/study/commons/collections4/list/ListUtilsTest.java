package study.commons.collections4.list;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class ListUtilsTest {

    /**
     * （★）emptyIfNull()和defaultIfNull()
     */
    @Test
    public void emptyIfNull_test() {
        List<String> lt = null;

        ListUtils.emptyIfNull(lt).forEach(str -> {
            log.info(str);
        });
    }

    @Test
    public void defaultIfNull_test() {
    }

    /**
     * （★）select()和selectRejected()
     */
    @Test
    public void select_test() {
        List<String> lt = Arrays.asList("1", "1", "2", "3");
        List<String> newLt = ListUtils.select(lt, (str) -> {
            if ("1".equalsIgnoreCase(str)) {
                return true;
            }
            return false;
        });
        log.info("{}", lt);
        log.info("{}", newLt);
    }

    @Test
    public void selectRejected_test() {
        List<String> lt = Arrays.asList("1", "1", "2", "3");
        List<String> newLt = ListUtils.selectRejected(lt, (str) -> {
            if ("1".equalsIgnoreCase(str)) {
                return true;
            }
            return false;
        });
        log.info("{}", lt);
        log.info("{}", newLt);
    }

    @Test
    public void test() {
    }
}
