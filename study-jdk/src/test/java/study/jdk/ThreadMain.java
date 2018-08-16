package study.jdk;

public class ThreadMain {

    public static void main(String[] args) {
//        new study.jdk.ThreadMain().testNew();
//        new study.jdk.ThreadMain().testRunnable();
        new ThreadMain().testBlocked();
    }

    public void testNew() {
        Thread t = new Thread();
        System.out.println(t.getState().name());
    }

    public void testRunnable() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    System.out.println(i);
                }
            }
        }, "RUNNABLE-Thread");
        thread.start();
    }

    public void testBlocked() {
        final Object lock = new Object();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " invoke");
                    try {
                        Thread.sleep(20000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "BLOCKED-Thread-A");
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + " invoke");
                    try {
                        Thread.sleep(20000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "BLOCKED-Thread-B");
        threadA.start();
        threadB.start();
    }
}
