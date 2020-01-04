package study.apache.commons.codec;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

@Slf4j
public class DigestUtils_Test {

    private static final String STR = "26803BDCD00D41CFA94BBD450E8E58F4" + System.currentTimeMillis();

    @Test
    public void md5_test() {
        //DigestUtils.md5("");
        String str = DigestUtils.md5Hex(STR);
        log.info("{}", str);
    }

    @Test
    public void sha1_test() {
        String str = DigestUtils.sha1Hex("abc123");
        log.info("{}", str);
    }

    /**
     * SHA1
     */
    @Test
    public void sha2_test() {
        //DigestUtils.sha1("");
        String str = DigestUtils.sha256Hex(STR);
        log.info("{}", str);
    }
}
