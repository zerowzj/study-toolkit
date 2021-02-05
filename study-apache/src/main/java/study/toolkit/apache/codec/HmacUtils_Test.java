package study.toolkit.apache.codec;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.junit.Test;

import javax.crypto.Mac;

@Slf4j
public class HmacUtils_Test {

    byte[] key = "35b1ab4d984eae5626cdda8d4ff12cf5".getBytes();

    String plaint = "/usercenter/v2/dict/area?nation=中国&province=河南&city=郑州市";

    @Test
    public void md5_test() {
        HmacUtils hmacUtils = new HmacUtils(HmacAlgorithms.HMAC_SHA_1, key);
        String base64 = Base64.encodeBase64String(hmacUtils.hmac(plaint));
        log.info(base64);
    }
}
