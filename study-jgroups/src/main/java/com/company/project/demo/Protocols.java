package com.company.project.demo;

import com.google.common.collect.Lists;
import org.jgroups.protocols.TCP;
import org.jgroups.protocols.TCPPING;
import org.jgroups.protocols.pbcast.GMS;
import org.jgroups.protocols.pbcast.NAKACK2;
import org.jgroups.protocols.pbcast.STATE_TRANSFER;
import org.jgroups.stack.Protocol;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.List;

public class Protocols {

    private static final int PORT = 7800;

    private static final String[] NODE_IPS = {"10.60.0.65", "10.60.0.67"};
//    private static final String[] NODE_IPS = {"47.93.194.39", "10.60.0.67"};

    public static List<Protocol> build() throws Exception {
        List<Protocol> protocolLt = Lists.newArrayList();

        //
        TCP tcp = new TCP();
        tcp.setBindAddress(InetAddress.getLocalHost());
        tcp.setBindPort(PORT);
        protocolLt.add(tcp);
        //
        List<InetSocketAddress> initialHosts = Lists.newArrayList();
        for (String node : NODE_IPS) {
            initialHosts.add(new InetSocketAddress(node, PORT));
        }
        TCPPING tcpping = new TCPPING();
        tcpping.setInitialHosts(initialHosts);
        protocolLt.add(tcpping);
        //
        NAKACK2 nakack2 = new NAKACK2();
        nakack2.setUseMcastXmit(false);
        nakack2.setDiscardDeliveredMsgs(true);
        protocolLt.add(nakack2);
        //
        GMS gms = new GMS();
        gms.setPrintLocalAddr(true);
        gms.setJoinTimeout(3 * 1000);
        protocolLt.add(gms);
        //
        STATE_TRANSFER state_transfer = new STATE_TRANSFER();
        protocolLt.add(state_transfer);

        return protocolLt;
    }

    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("HostName: " + address.getHostName());
        System.out.println("HostAddress: " + address.getHostAddress());
        System.out.println("CanonicalHostName: " + address.getCanonicalHostName());
    }
}
