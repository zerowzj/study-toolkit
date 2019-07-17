package study.jvm.gc;

public class Client_Main {

    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        System.out.println("我在活着...");
        byte[] a1 = new byte[_1M];
        byte[] a2 = new byte[_1M];
        System.out.println("我要死了...");
    }
}
