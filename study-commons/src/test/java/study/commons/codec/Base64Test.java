package study.commons.codec;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

public class Base64Test {

    byte[] bytes = "".getBytes();

    @Test
    public void encodeBase64_test() {
        Base64.encodeBase64(bytes);
    }

    @Test
    public void encodeBase64String_test() {
        Base64.encodeBase64String(bytes);
    }

    @Test
    public void decodeBase64_test() {
        Base64.decodeBase64(bytes);
    }
}
