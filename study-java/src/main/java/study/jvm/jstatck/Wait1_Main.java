package study.jvm.jstatck;

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
}
