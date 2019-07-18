package study.jvm.classloader.init;

public class MyObj {

    protected static String NAME = "wangzhj";

    protected final static String GENDER = "男";

    protected static int AGE;

    protected final static void sayHi() {
        System.out.println("hi...");
    }

    static {
        System.out.println("init class MyObj");
    }

    public MyObj() {
        System.out.println("constructor of MyObj");
    }
}
