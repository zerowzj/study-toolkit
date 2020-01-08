package study.commons.lang3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

@Slf4j
public class StringUtils_Test {

    /**
     * ====================
     * （★）isEmpty（空的）
     * ====================
     */
    @Test
    public void isEmpty_test() {
        String str1 = "abc";
        String str2 = "";
        String str3 = null;
        log.info("{}", StringUtils.isEmpty(str1));
        log.info("{}", StringUtils.isEmpty(str2));
        log.info("{}", StringUtils.isEmpty(str3));
    }

    @Test
    public void isNotEmpty_test() {
        String str1 = "1";
        boolean isAnyEmpty = StringUtils.isNotEmpty(str1);
        log.info("isAnyEmpty={}", isAnyEmpty);
    }

    @Test
    public void isAllEmpty_test() {
        String str1 = "";
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
    public void isNoneEmpty_test() {
        String str1 = "1";
        String str2 = "2";
        boolean isAnyEmpty = StringUtils.isNoneEmpty(str1, str2);
        log.info("isAnyEmpty={}", isAnyEmpty);
    }

    /**
     * ====================
     * （★）isBlank（空白的）
     * ====================
     */
    @Test
    public void isBlank_test() {
        String str1 = "1";
        String str2 = "";
        String str3 = null;
        log.info("{}", StringUtils.isBlank(str1));
        log.info("{}", StringUtils.isBlank(str2));
        log.info("{}", StringUtils.isBlank(str3));
    }

    @Test
    public void isNotBlank_test() {
        String str1 = "1";
        boolean isAllEmpty = StringUtils.isNotBlank(str1);
        log.info("isAllEmpty= {}", isAllEmpty);
    }

    @Test
    public void isAllBlank_test() {
        String str1 = null;
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
    public void isNoneBlank_test() {
        String str1 = "1";
        String str2 = null;
        boolean isAllEmpty = StringUtils.isNoneBlank(str1, str2);
        log.info("isAllEmpty= {}", isAllEmpty);
    }

    /**
     * ====================
     * （★）大小写
     * ====================
     */
    @Test
    public void isAllLowerCase_test() {
        String str1 = "ABC";
        String str2 = "abc";
        String str3 = "AbC";
        String str4 = "";
        String str5 = null;
       log.info("{}", StringUtils.isAllLowerCase(str1));
       log.info("{}", StringUtils.isAllLowerCase(str2));
       log.info("{}", StringUtils.isAllLowerCase(str3));
       log.info("{}", StringUtils.isAllLowerCase(str4));
       log.info("{}", StringUtils.isAllLowerCase(str5));
    }

    @Test
    public void isAllUpperCase_test() {
        String str1 = "ABC";
        String str2 = "abc";
        String str3 = "AbC";
        String str4 = "";
        String str5 = null;
        log.info("{}", StringUtils.isAllUpperCase(str1));
        log.info("{}", StringUtils.isAllUpperCase(str2));
        log.info("{}", StringUtils.isAllUpperCase(str3));
        log.info("{}", StringUtils.isAllUpperCase(str4));
        log.info("{}", StringUtils.isAllUpperCase(str5));
    }

    /**
     * ====================
     * （★）Compare
     * ====================
     */
    @Test
    public void compare_test() {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = "ABC";
        String str4 = "123";
        log.info("{}", StringUtils.compare(str1, str2));
        log.info("{}", StringUtils.compare(str2, str3));
        log.info("{}", StringUtils.compare(str3, str4));
    }

    @Test
    public void compareIgnoreCase_test() {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = "ABC";
        String str4 = "123";
        log.info("{}", StringUtils.compareIgnoreCase(str1, str2));
        log.info("{}", StringUtils.compareIgnoreCase(str2, str3));
        log.info("{}", StringUtils.compareIgnoreCase(str3, str4));
    }

    @Test
    public void compareIgno1reCase_test() {
//        StringUtils.strip
    }
}
