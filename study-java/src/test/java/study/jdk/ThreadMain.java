package study.jdk;

public class ThreadMain {
    String str1 = "a" + new String("bc");
    String str2 = "abc";

    public static void main(String[] args) {
//        new study.jdk.ThreadMain().testNew();
//        new study.jdk.ThreadMain().testRunnable();
//        new ThreadMain().testBlocked();

        String str1 = "hello";
        String str2 = "hello";

        ThreadMain t = new ThreadMain();
        System.out.println(t.str1 == t.str2);


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
