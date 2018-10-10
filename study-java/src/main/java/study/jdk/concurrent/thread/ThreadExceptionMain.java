package study.jdk.concurrent.thread;

import study.Sleeps;

/**
 * 如果这个异常没有被捕获的话，这个线程就停止执行了。
 * 另外重要的一点是：如果这个线程持有某个某个对象的监视器，那么这个对象监视器会被立即释放
 */
public class ThreadExceptionMain {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1() {
        Thread t = new Thread(() -> {
            int i = 0;
            for (; ; ) {
                i++;
                print(i);
            }
        });
        t.start();
    }

    private static void test2() {
        Thread t = new Thread(() -> {
            int i = 0;
            for (; ; ) {
                i++;
                try {
                    print(i);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        t.start();
    }

    private static void print(int i) {
        Sleeps.milliseconds(500);
        System.out.println("==>" + i);
        if (i == 10) {
            throw new NullPointerException();
        }
    }
}
