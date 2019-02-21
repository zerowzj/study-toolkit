package study.commons.codec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;

public class Base64Test {

    byte[] bytes = "".getBytes();

    @Test
    public void encodeBase64_test() {
        Base64.encodeBase64(bytes);
    }

    @Test
    public void encodeBase64String_test() {
        try {
            byte[] bytes = FileUtils.readFileToByteArray(new File("d:/query_dubbo.jmx"));
            String str = Base64.encodeBase64String(bytes);
            System.out.println(str);

            FileUtils.writeByteArrayToFile(new File("d:/ttt.jms"), Base64.decodeBase64(str.getBytes()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void decodeBase64_test() {
        Base64.decodeBase64(bytes);
    }
}
