package study.commons.io;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;

public class IOUtilsTest {

    //toByteArray
    @Test
    public void toByteArray_test() throws Exception {
        InputStream in = new FileInputStream("d:/win10.zip");
        byte[] bytes = IOUtils.toByteArray(in);
        byte[] heads = ArrayUtils.subarray(bytes, 0, 10);
        String str = Hex.encodeHexString(heads, false);
        System.out.println(str);
    }

    //toString
    @Test
    public void toString_test() throws Exception {
        InputStream in = new FileInputStream("d:/234.docx");
        IOUtils.toString(in, "");
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
