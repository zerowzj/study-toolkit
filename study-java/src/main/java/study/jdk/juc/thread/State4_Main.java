
package study.jdk.juc.thread;

/**
 *"ssssssssss" #11 prio=5 os_prio=0 tid=0x000000001b8f7000 nid=0x2774 in Object.wait() [0x000000001c1cf000]
 *    java.lang.Thread.State: WAITING (on object monitor)
 *         at java.lang.Object.wait(Native Method)
 *         - waiting on <0x00000000d7149990> (a java.lang.Object)
 *         at java.lang.Object.wait(Object.java:502)
 *         at study.jdk.juc.thread.State4_Main.lambda$main$0(State4_Main.java:14)
 *         - locked <0x00000000d7149990> (a java.lang.Object)
 *         at study.jdk.juc.thread.State4_Main$$Lambda$1/1607521710.run(Unknown Source)
 *         at java.lang.Thread.run(Thread.java:745)
 */
public class State4_Main {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }, "ssssssssss");
        t.start();
    }
}
