package study.jvm.classloader.init;

public class MyObj {

    protected final static String NAME = "wangzhj";

    protected final static int AGE = 35;

    protected final static void sayHi(){
        System.out.println("hi...");
    }

    static {
        System.out.println("i am static code block of MyObj");
    }

    public MyObj() {
        System.out.println("i am constructor of MyObj");
    }
}
