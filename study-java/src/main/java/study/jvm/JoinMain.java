package study.jvm;

import study.Sleeps;

public class JoinMain {

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Sleeps.minutes(5);
            }
        }, "my-thread");
        t.start();

        try {
            t.join();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
