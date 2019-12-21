package study.apache.commons.codec;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class DigestUtilsTest {

    private static final String STR = "26803BDCD00D41CFA94BBD450E8E58F4"+System.currentTimeMillis();

    /**
     * MD5
     */
    @Test
    public void md5_test() {
        DigestUtils.md5("");
        String str = DigestUtils.md2Hex(STR);
        System.out.println(str.toUpperCase().length());
    }

    /**
     * SHA1
     */
    @Test
    public void sha1_test() {
        String str = DigestUtils.sha1Hex("abc123");
        System.out.println(str);
    }

    /**
     * SHA1
     */
    @Test
    public void sha2_test() {
        DigestUtils.sha1("");
        String str = DigestUtils.sha256Hex(STR);
        System.out.println(str);
        System.out.println(str.length());
    }
}
