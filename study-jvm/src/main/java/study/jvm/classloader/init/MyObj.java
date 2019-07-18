package study.jvm.classloader.init;

public class MyObj {

    protected static String NAME = "wangzhj";

    protected static int AGE;

    static {
        System.out.println("1");
    }

    public MyObj() {
        System.out.println("2");
    }
}
