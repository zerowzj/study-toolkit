package study.jvm.gc;

/**
 * -Xms1m -Xmx1m -XX:+PrintGCDetails -XX:+UseParallelGC
 */
public class UseParallelGC_Main {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {

//        byte[] all1 = new byte[_1M];
//        byte[] all2 = new byte[_1M];
        System.out.println("我在活着。。。。");
//        System.gc();
        System.out.println("我要死了。。。。");
    }
}
