package study.apache.commons.codec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;

public class ApiMac {
    private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";

    private static final String CHARSET_NAME = "UTF-8";

    private Mac mac;

    public ApiMac(String appKey) {
        try {
            byte[] appKeyBytes = appKey.getBytes(CHARSET_NAME);
            SecretKeySpec signingKey = new SecretKeySpec(appKeyBytes, HMAC_SHA1_ALGORITHM);
            mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
            mac.init(signingKey);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize HMAC-SHA1", e);
        }
    }

    public String sign(String data) {
        String hash;
        try {
            byte[] rawHash = mac.doFinal(data.getBytes(CHARSET_NAME));
            hash = Base64.encodeBase64String(rawHash);
        } catch (Exception e) {
            throw new RuntimeException("Failed to compute hash", e);
        } finally {
            mac.reset();
        }
        return hash;
    }

    public static void main(String[] args) throws Exception {
        String data = FileUtils.readFileToString(new File("d:\\test.txt"), "UTF-8");
        System.out.println(new ApiMac("35b1ab4d984eae5626cdda8d4ff12cf5").sign(data));
    }
}
