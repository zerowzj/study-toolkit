package study.guava.io;

import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.Resources;
import org.junit.Test;

import java.net.URL;

public class ResourcesTest {

    @Test
    public void test_getResource() {
        URL url = Resources.getResource("");
        Resources.getResource(null, null);
    }

    @Test
    public void test_asSource() throws Exception {
        ByteSource byteSource = Resources.asByteSource(new URL(""));
        CharSource charSource = Resources.asCharSource(null, null);
    }
}
