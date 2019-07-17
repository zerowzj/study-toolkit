package study.jvm.gc;

/**
 * -Xms1m -Xmx1m -XX:+PrintGCDetails -XX:+UseParNewGC
 */
public class UseParNewGC_Main {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] a1 = new byte[_1M];
        byte[] a2 = new byte[_1M];
        System.out.println("我在活着...");
//        System.gc();
        System.out.println("我要死了...");
    }
}
