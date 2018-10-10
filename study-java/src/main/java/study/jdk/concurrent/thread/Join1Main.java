package study.jdk.concurrent.thread;

import study.Sleeps;

public class Join1Main {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            Sleeps.seconds(2);
            System.out.println("i am t thread");
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException ex) {

        }

        System.out.println("i am main thread");
    }
}
