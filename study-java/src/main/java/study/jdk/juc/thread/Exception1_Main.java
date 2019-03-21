package study.jdk.juc.thread;

import study.Sleeps;

/**
 * 如果这个异常没有被捕获的话，这个线程就停止执行了。
 * 另外重要的一点是：如果这个线程持有某个某个对象的监视器，那么这个对象监视器会被立即释放
 *
 * 异常后线程停止运行
 */
public class Exception1_Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            int i = 0;
            for (; ; ) {
                i++;
                Sleeps.milliseconds(500);
                System.out.println("==>" + i);
                if (i == 10) {
                    throw new NullPointerException();
                }
            }
        });
        t.start();
    }
}
