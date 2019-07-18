package study.jvm.classloader.init;

public class MyObj {

    protected static String NAME = "wangzhj";

    protected static int AGE;

    static {
        System.out.println("i am static code block of MyObj");
    }

    public MyObj() {
        System.out.println("i am constructor of MyObj");
    }
}
