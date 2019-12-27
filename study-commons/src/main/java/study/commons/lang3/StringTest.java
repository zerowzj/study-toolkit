package study.commons.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

@Slf4j
public class StringTest {

    @Test
    public void isAll_test() {
        String str1 = "1";
        String str2 = null;
        boolean isAllEmpty = StringUtils.isAllEmpty(str1, str2);
        log.info("isAllEmpty= {}", isAllEmpty);

        boolean isAllBlank = StringUtils.isAllBlank(str1, str2);
        log.info("isAllEmpty= {}", isAllBlank);
    }

    @Test
    public void isAllBlank_test() {
        String str1 = "1";
        String str2 = null;
        boolean isAnyEmpty = StringUtils.isAnyEmpty(str1, str2);
        log.info("isAnyEmpty={}", isAnyEmpty);

        boolean isAnyBlank = StringUtils.isAnyBlank(str1, str2);
        log.info("isAnyBlank={}", isAnyBlank);


    }

    @Test
    public void join_test() {
        String path = "/ab/c";
        String uriVars = "";
        String str = StringUtils.join(path, "?", uriVars);
        log.info("{}", str);
    }
}
