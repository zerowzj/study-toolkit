package study.jvm;

public class WaitMain {

    static Object lock = new Object();

    public static void main(String[] args) {
        synchronized (lock) {
            try {
                lock.wait();
            } catch (Exception ex) {
            }
        }
    }
}
