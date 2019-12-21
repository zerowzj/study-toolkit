package study.apache.commons.codec;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

public class HexTest {

    String str = "123";

    byte[] bytes = "123".getBytes();

    @Test
    public void encodeHexString_test() {
        Hex.encodeHexString(bytes);
    }

    @Test
    public void encodeHex_test() {
        Hex.encodeHex(bytes);
    }

    @Test
    public void decodeHex_test() {
        try {
            Hex.decodeHex("");
        } catch (Exception ex) {

        }
    }
}
