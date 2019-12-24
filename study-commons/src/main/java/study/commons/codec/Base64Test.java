package study.commons.codec;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

@Slf4j
public class Base64Test {

    private String str = "abc123!@#";

    private String base64Str = "YXNmYTEyMzEyIUAj";

    @Test
    public void encode_test() {
        String base64Str = Base64.encodeBase64String(str.getBytes());
        log.info(base64Str);
    }

    @Test
    public void decode_test() {
        byte[] bytes = Base64.decodeBase64(base64Str);
        log.info("{}", new String(bytes));
    }
}
