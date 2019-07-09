package study.jvm.jstatck;

import java.util.concurrent.locks.LockSupport;

public class Parking_Main {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            LockSupport.park();
        }, "t");
        t.start();
    }
}
