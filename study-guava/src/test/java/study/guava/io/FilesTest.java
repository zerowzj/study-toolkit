package study.guava.io;

import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;


public class FilesTest {

    @Test
    public void test_to() throws Exception {
        Files.toByteArray(new File(""));
        Files.toString(null, null);
    }

    @Test
    public void test_as() throws Exception {
//        Files.asByteSource();
//        Files.asCharSource();
    }
}
