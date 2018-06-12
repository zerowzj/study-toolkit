package study.guava.base;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.File;

public class JoinerTest {

    private static final String APP_DIR = System.getProperty("user.dir");

    private static final String KEY_ROOT_DIR = "config";

    @Test
    public void join_test() {
//        String[] strArr = new String[]{"1", "2"};
//        System.out.println(Joiner.on("-").join(strArr));

        String dir = Joiner.on(File.separator).join(APP_DIR, KEY_ROOT_DIR, "spearssl\\");
        System.out.println(dir);
    }

}
