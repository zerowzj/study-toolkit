package com.company.project;

import com.company.project.demo.SimpleChat;

import java.net.InetAddress;
import java.net.URL;

public class Startup {

    public static void main(String[] args) throws Exception {
        InetAddress inetAdd = InetAddress.getLocalHost();
        String host = inetAdd.getHostName();
        new SimpleChat().start(host);
    }

    public static void main2(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource("tcp.xml");
        System.out.println(url.toString());
    }
}
