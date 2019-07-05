package study.jvm;

import study.Sleeps;

/**
 * （1）wait时线程堆栈信息
 */
public class Wait1_Main {


    public static void main(String[] args) {

        Object lock = new Object();

        Thread t = new Thread(() -> {
            try {
                lock.wait();
            } catch (InterruptedException ex) {

            }
        });

    }



    /**
     * synchronized获得对象锁是线程的实例时，此时比较特殊，
     * 当该线程终止的时候，会调用线程自身的notifyAll()方法，会通知所有等待在该线程对象上的线程。
     */
    public void test2() {
        Thread t = new Thread() {
            public void run() {
                System.out.println("执行线程中方法");
                Sleeps.seconds(5);
            }
        };
        t.start();

        synchronized (t) {
            try {
                t.wait(); //当线程终止的时候，会调用线程自身的notifyAll()方法
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("执行到了这里");
        }
    }
}
