package test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {

    static {
        System.out.println("Static init Main.");
    }

    {
        System.out.println("Instance init Main.");
    }

    Main() {
        System.out.println("Constructor Main.");
    }

    public static void main(String[] args) {
//        C c = new C();
        System.out.println("+++++++++++=");
        B b = new B();

        String ip1 = "192.168.1.1";
        String ip2 = "192.168.1.2";

        Map<Integer, String> map = new HashMap<>();
//        map.put(ip1.hashCode(), ip1);
//        map.put(ip2.hashCode(), ip2);

        ip1.hashCode();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (Exception ex) {

                }
            }
        }).start();
//        System.exit(1);
    }
}