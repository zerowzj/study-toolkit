package study.toolkit.apache.io;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class FileUtils_Test {

    private static Charset CHARSET_UTF_8 = Charset.forName("UTF-8");

    /**
     * （★）读文件
     */
    @Test
    public void readLines_test() throws Exception {
        List<String> strLt = FileUtils.readLines(new File("D:\\Okay\\ROOT\\"), "UTF-8");
        strLt.forEach(str -> {
            log.info(str);
        });
    }

    @Test
    public void readFileToString_test() throws Exception {
        String str = FileUtils.readFileToString(new File(""), CHARSET_UTF_8);
        log.info(str);
    }

    @Test
    public void readFileToByteArray_test() throws Exception {
        byte[] bytes = FileUtils.readFileToByteArray(new File(""));
    }

    /**
     * （★）写文件
     */
    @Test
    public void writeLines_test() throws Exception {
        List<String> strLt = Arrays.asList("", "", "");
        FileUtils.writeLines(new File(""), strLt);
    }

    @Test
    public void writeStringToFile_test() throws Exception {
        String str = null;
        FileUtils.writeStringToFile(new File(""), str, CHARSET_UTF_8);
    }

    @Test
    public void writeByteArrayToFile_test() throws Exception {
        byte[] bytes = null;
        FileUtils.writeByteArrayToFile(new File(""), bytes);
    }

    @Test
    public void write_test() throws Exception {
        String str = null;
        FileUtils.write(new File(""), str, CHARSET_UTF_8);
    }

    /**
     * （★）文件流
     */
    @Test
    public void openInputStream_test() throws Exception {
        FileInputStream fis = FileUtils.openInputStream(new File(""));
    }

    @Test
    public void openOutputStream_test() throws Exception {
        FileOutputStream fos = FileUtils.openOutputStream(new File(""));
    }

    @Test
    public void copyInputStreamToFile_test() throws Exception {
        FileUtils.copyInputStreamToFile(null, new File(""));
    }
}
