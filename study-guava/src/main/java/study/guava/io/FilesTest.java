package study.guava.io;

import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;

@Slf4j
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
