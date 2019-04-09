package study.jdk.jcf.list;

import org.junit.Test;

public class System_Test {

    @Test
    public void test_arraycopy() {
        Object src = null;
        int srcPos = 0;
        Object dest = null;
        int destPos = 0;
        int length = 5;
        System.arraycopy(src, srcPos, dest, destPos, length);
    }
}
