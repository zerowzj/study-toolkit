package study.toolkit.easyexcel;

import java.io.InputStream;

public class TestDataUtils {

    private static String TEST_DATA_PATH = "excel/";

    private static String DEFAULT_ENCODING = "UTF-8";

    public static InputStream getStream(String fileName) {
        InputStream is = null;
        try {
            is = ClassLoader.getSystemResourceAsStream(TEST_DATA_PATH + fileName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return is;
    }
}
