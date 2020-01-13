package com.company.project.jgroups;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.util.function.Supplier;

/**
 * 绑定地址
 *
 * @author wangzhj
 */
public class BindAddr implements Supplier<InetAddress> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomReceiver.class);

    @Override
    public InetAddress get() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
            LOGGER.info("   host_name: {}", address.getHostName());
            LOGGER.info("host_address: {}", address.getHostAddress());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return address;
    }
}
