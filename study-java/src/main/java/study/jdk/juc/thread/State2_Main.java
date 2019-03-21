
package study.jdk.juc.thread;

import study.Sleeps;

/**
 * jps jstack
 *
 *"ssssssssss" #11 prio=5 os_prio=0 tid=0x000000001bb26800 nid=0x28ac waiting on condition [0x000000001c40f000]
 *    java.lang.Thread.State: TIMED_WAITING (sleeping)
 *         at java.lang.Thread.sleep(Native Method)
 *         at java.lang.Thread.sleep(Thread.java:340)
 *         at java.util.concurrent.TimeUnit.sleep(TimeUnit.java:386)
 *         at study.Sleeps.seconds(Sleeps.java:9)
 *         at study.jdk.juc.thread.State2_Main.lambda$main$0(State2_Main.java:15)
 *         at study.jdk.juc.thread.State2_Main$$Lambda$1/764977973.run(Unknown Source)
 *         at java.lang.Thread.run(Thread.java:745)
 */
public class State2_Main {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Sleeps.seconds(Integer.MAX_VALUE);
        }, "ssssssssss");
        t.start();
    }
}
