package com.company.project.demo;

import com.company.project.jgroups.CustomReceiver;
import com.google.common.io.ByteSource;
import com.google.common.io.Resources;
import org.jgroups.JChannel;
import org.jgroups.Message;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.Scanner;

public class SimpleChat {

    private JChannel channel;

    public void start(String name) throws Exception {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("          host_name: " + address.getHostName());
        System.out.println("       host_address: " + address.getHostAddress());
        System.out.println("canonical_host_name: " + address.getCanonicalHostName());
        //配置
        URL url = Resources.getResource("tcp.xml");
        System.out.println("======> " + url.toString());
        ByteSource byteSource = Resources.asByteSource(url);
        InputStream is = byteSource.openStream();

//        channel = new JChannel(Protocols.build());
        channel = new JChannel(is);
        channel.setReceiver(new CustomReceiver())
                .setDiscardOwnMessages(false)
                .name(name)
                .connect("ChatCluster")
                .getState(null, 10000);

        sendMessage();
        //
        channel.close();
    }

    private void sendMessage() throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            Message msg = new Message(null, "[123213]" + scanner.next());
            channel.send(msg);
        }
    }
}
