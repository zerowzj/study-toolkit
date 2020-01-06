package study.commons.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

@Slf4j
public class StringUtils_Test {

    /**
     * ====================
     * （★）Empty
     * ====================
     */
    @Test
    public void isAllEmpty_test() {
        String str1 = "1";
        String str2 = null;
        boolean isAllEmpty = StringUtils.isAllEmpty(str1, str2);
        log.info("isAllEmpty= {}", isAllEmpty);
    }

    @Test
    public void isAnyEmpty_test() {
        String str1 = "1";
        String str2 = "";
        boolean isAnyEmpty = StringUtils.isAnyEmpty(str1, str2);
        log.info("isAnyEmpty={}", isAnyEmpty);
    }

    @Test
    public void isEmpty_test() {
        String str = "1";
        boolean isAnyEmpty = StringUtils.isEmpty(str);
        log.info("isAnyEmpty={}", isAnyEmpty);
    }

    @Test
    public void isNotEmpty_test() {
        String str1 = "1";
        boolean isAnyEmpty = StringUtils.isNotEmpty(str1);
        log.info("isAnyEmpty={}", isAnyEmpty);
    }

    @Test
    public void isNoneEmpty_test() {
        String str1 = "1";
        String str2 = "2";
        boolean isAnyEmpty = StringUtils.isNoneEmpty(str1, str2);
        log.info("isAnyEmpty={}", isAnyEmpty);
    }

    /**
     * ====================
     * （★）Blank
     * ====================
     */
    @Test
    public void isAllBlank_test() {
        String str1 = "1";
        String str2 = null;
        boolean isAllEmpty = StringUtils.isAllBlank(str1, str2);
        log.info("isAllEmpty= {}", isAllEmpty);
    }

    @Test
    public void isAnyBlank_test() {
        String str1 = "1";
        String str2 = null;
        boolean isAllEmpty = StringUtils.isAnyBlank(str1, str2);
        log.info("isAllEmpty= {}", isAllEmpty);
    }

    @Test
    public void isBlank_test() {
        String str1 = "1";
        String str2 = null;
        boolean isAllEmpty = StringUtils.isBlank(str1);
        log.info("isAllEmpty= {}", isAllEmpty);
    }

    @Test
    public void isNotBlank_test() {
        String str1 = "1";
        String str2 = null;
        boolean isAllEmpty = StringUtils.isNotBlank(str1);
        log.info("isAllEmpty= {}", isAllEmpty);
    }

    @Test
    public void isNoneBlank_test() {
        String str1 = "1";
        String str2 = null;
        boolean isAllEmpty = StringUtils.isNoneBlank(str1, str2);
        log.info("isAllEmpty= {}", isAllEmpty);
    }

    /**
     * ====================
     * （★）Blank
     * ====================
     */
    @Test
    public void isAllLowerCase_test() {
        String str1 = "1";
        String str2 = null;
        boolean isAllEmpty = StringUtils.isAllLowerCase(str2);
        log.info("isAllEmpty= {}", isAllEmpty);
    }

    @Test
    public void isAllUpperCase_test() {
        String str1 = "1";
        boolean is = StringUtils.isAllUpperCase(str1);
        log.info("{}", is);
    }

    /**
     * ====================
     * （★）Blank
     * ====================
     */
    @Test
    public void join_test() {
        String path = "/ab/c";
        String uriVars = "";
        String str = StringUtils.join(path, "?", uriVars);
        log.info("{}", str);
    }
}
