package study.jdk.juc.thread;

/**
 *
 * 输出结果：
 * Aprint: 1
 * Aprint: 2
 * Aprint: 3
 * Bprint:1
 * Bprint:2
 * Bprint:3
 */
public class Join3_Main {

    public static void main(String[] args) {
        final Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    A.join();
                }catch (Exception ex) {
                }
                printNumber("B");
            }
        });
        B.start();
        A.start();
//        try {
//            B.join();
//        } catch (InterruptedException ex) {
//        }

        System.out.println("main thread");
    }

    private static void printNumber(String threadName) {
        int i = 0;
        while (i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + "print:" + i);
        }
    }
}
