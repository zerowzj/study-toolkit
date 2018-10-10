package study.jdk.concurrent.thread;

import study.Sleeps;

public class Join1Main {

    public static void main(String[] args) {
        Join1Main main = new Join1Main();
        main.test1();
        main.test2();
        System.out.println("i am main thread");
    }

    /**
     * 演示join原理
     */
    public void test1() {
        Thread t = new Thread(() -> {
            Sleeps.seconds(2);
            System.out.println("i am t thread");
        });
        t.start();
        try {
            t.join();

//            synchronized (t) {
//                t.wait();
//            }

        } catch (InterruptedException ex) {
        }
    }

    /**
     * 演示只阻塞父线程
     */
    public void test2() {
        Thread t1 = new Thread(() -> {
            Sleeps.seconds(2);
            System.out.println("i am t1 thread");
        });
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException ex) {
            }
            System.out.println("i am t2 thread");
        });
        t1.start();
        t2.start();
    }
}
