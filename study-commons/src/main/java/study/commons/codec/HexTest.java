package study.commons.codec;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

@Slf4j
public class HexTest {

    byte[] data = "123".getBytes();

    String hexStr = "313233";

    @Test
    public void encode_test() {
        String str = Hex.encodeHexString(data);
        log.info("{}", str);
    }

    @Test
    public void decode_test() throws Exception {
        byte[] data = Hex.decodeHex(hexStr);
        log.info("{}", new String(data));
    }
}
