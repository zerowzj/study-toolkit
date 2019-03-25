package study.jdk.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Join4_Main {

    private static Logger LOGGER = LoggerFactory.getLogger(Join4_Main.class);

    class MyThread extends Thread {
        private Thread t;

        MyThread(Thread t) {
            this.t = t;
        }

        @Override
        public void run() {
            try {
                t.join();
                System.out.println("t3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void test() {
        Thread t1 = new Thread(() -> {
            System.out.println("t1");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("t2");
        });
        Thread t3 = new MyThread(t1);

        t3.start();
        t2.start();
        t1.start();
    }

    public static void main(String[] args) {
        new Join4_Main().test();
    }
}
