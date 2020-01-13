package study.commons.io;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Slf4j
public class IOUtilsTest {

    /**
     * （★）读文件
     */
    @Test
    public void toString_test() throws Exception {
        InputStream in = new FileInputStream("d:/234.docx");
        String str = IOUtils.toString(in, "");
        log.info(str);
    }

    //toByteArray
    @Test
    public void toByteArray_test() throws Exception {

        InputStream in = new FileInputStream("d:/pic.txt");
        byte[] bytes = IOUtils.toByteArray(in);
        byte[] tt = Base64.decodeBase64(bytes);
        FileUtils.writeByteArrayToFile(new File("d:/t.jpg"), tt);
    }


    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
}
