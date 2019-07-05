package study.jvm.jstatck;

import study.Sleeps;

public class Join2_Main {

    public static void main(String[] args) {
        Join2_Main joinMain = new Join2_Main();
        joinMain.test1();
    }

    public void test1() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Sleeps.minutes(5);
            }
        }, "my-thread");
        t.start();
        try {
            t.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
