package study.commons.codec;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.junit.Test;

import javax.crypto.Mac;

public class HmacUtilsTest {

    byte[] key = "123213".getBytes();

    /**
     *
     */
    @Test
    public void md5_test() {
        HmacUtils hmacUtils = new HmacUtils(HmacAlgorithms.HMAC_SHA_1, key);
        hmacUtils.hmacHex("");
    }
}
