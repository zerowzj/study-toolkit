package study.jdk.concurrent.thread;

/**
 * 输出结果：
 * t2
 * t1
 * t3
 */
public class Join2Main {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2");
            }
        });
        Thread t3 = new MyThread(t1);
        t3.start();
        t2.start();
        t1.start();
    }

    static class MyThread extends Thread {
        Thread t;

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
}
