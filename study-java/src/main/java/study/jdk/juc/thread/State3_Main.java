
package study.jdk.juc.thread;

import study.Sleeps;

/**
 * "main" #1 prio=5 os_prio=0 tid=0x0000000004772800 nid=0xd38 in Object.wait() [0x00000000045af000]
 *    java.lang.Thread.State: WAITING (on object monitor)
 *         at java.lang.Object.wait(Native Method)
 *         - waiting on <0x00000000d71495b8> (a java.lang.Thread)
 *         at java.lang.Thread.join(Thread.java:1249)
 *         - locked <0x00000000d71495b8> (a java.lang.Thread)
 *         at java.lang.Thread.join(Thread.java:1323)
 *         at study.jdk.juc.thread.State3_Main.main(State3_Main.java:18)
 *
 * "main" #1 prio=5 os_prio=0 tid=0x0000000004e32800 nid=0x43ac in Object.wait() [0x0000000004c5f000]
 *    java.lang.Thread.State: TIMED_WAITING (on object monitor)
 *         at java.lang.Object.wait(Native Method)
 *         - waiting on <0x00000000d7149900> (a java.lang.Thread)
 *         at java.lang.Thread.join(Thread.java:1257)
 *         - locked <0x00000000d7149900> (a java.lang.Thread)
 *         at study.jdk.juc.thread.State3_Main.main(State3_Main.java:25)
 */
public class State3_Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Sleeps.seconds(Integer.MAX_VALUE);
        }, "ssssssssss");
        t.start();

        try {
            t.join(Integer.MAX_VALUE);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
