package study.jdk.net;

import org.junit.Test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class TT {

    @Test
    public void test() {
        Enumeration en;
        try {
            en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                NetworkInterface intf = (NetworkInterface) en.nextElement();
                Enumeration<InetAddress> addrs = intf.getInetAddresses();
                while (addrs.hasMoreElements())
                    System.out.println(addrs.nextElement());
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
