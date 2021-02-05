package study.toolkit.apache.codec;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

@Slf4j
public class Base64_Test {

    private String str = "abc123!@#";

    private String base64Str = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ3emoiLCJleHAiOjE1NzkwNTU1MDh9._AntDgLWTam4zTTQMelpkJBzVrGNxtWq9aCZa3Hkt_bX2S3LcdwRapvt2GlJKOqQBbVbEyrQwM-j6LGH9kYGdw";

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
