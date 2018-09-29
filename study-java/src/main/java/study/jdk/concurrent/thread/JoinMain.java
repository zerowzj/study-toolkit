package study.jdk.concurrent.thread;

public class JoinMain {

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
