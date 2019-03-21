package study.jdk.juc.thread;

/**
 * "ssssssssss" #11 prio=5 os_prio=0 tid=0x000000001bf5c000 nid=0x4dc4 in Object.wait() [0x000000001c84f000]
 *    java.lang.Thread.State: WAITING (on object monitor)
 *         at java.lang.Object.wait(Native Method)
 *         - waiting on <0x00000000d71495b0> (a java.lang.Object)
 *         at java.lang.Object.wait(Object.java:502)
 *         at study.jdk.juc.thread.State4_Main.lambda$main$0(State4_Main.java:22)
 *         - locked <0x00000000d71495b0> (a java.lang.Object)
 *         at study.jdk.juc.thread.State4_Main$$Lambda$1/1607521710.run(Unknown Source)
 *         at java.lang.Thread.run(Thread.java:745)
 *
 * "ssssssssss" #11 prio=5 os_prio=0 tid=0x000000001ae53800 nid=0x45bc in Object.wait() [0x000000001bfaf000]
 *    java.lang.Thread.State: TIMED_WAITING (on object monitor)
 *         at java.lang.Object.wait(Native Method)
 *         - waiting on <0x00000000d7149a40> (a java.lang.Object)
 *         at study.jdk.juc.thread.State4_Main.lambda$main$0(State4_Main.java:23)
 *         - locked <0x00000000d7149a40> (a java.lang.Object)
 *         at study.jdk.juc.thread.State4_Main$$Lambda$1/1607521710.run(Unknown Source)
 *         at java.lang.Thread.run(Thread.java:745)
 */
public class State4_Main {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread t = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(Integer.MAX_VALUE);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }, "ssssssssss");
        t.start();
    }
}
