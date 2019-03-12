package test.study.jdk.concurrent.helper;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            final int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //latch.countDown();
                    System.out.println(Thread.currentThread().getName() + "==>" + j);
                    latch.countDown();
                }
            }, "Thread-" + i).start();
        }
        System.out.println("bbb");
        try {
            latch.await();
        } catch (Exception ex) {
        }
        System.out.println("aaa");
    }
}
