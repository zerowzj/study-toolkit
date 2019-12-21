package study.commons.io;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.Collection;

public class FileUtilsTest {

    private static final String APP_DIR = System.getProperty("user.dir");

    private static final String KEY_ROOT_DIR = "config";

    @Test
    public void test() {

        Collection<File> t = FileUtils.listFiles(new File("D:\\Okay\\ROOT\\"), new String[]{"tar.gz"}, false);
        for (File f : t) {
            System.out.println(f.getName());
        }
    }
}
