package study.jvm.classloader.init;

import org.junit.Test;

public class Static_Test {

    @Test
    public void getstatic_test() {
        String name = MyObj.NAME;
    }

    @Test
    public void setstatic_test() {
//        MyObj.AGE = 32;
    }

    @Test
    public void invokestatic_test() {
        MyObj.sayHi();
    }
}
