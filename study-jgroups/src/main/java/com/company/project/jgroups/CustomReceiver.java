package com.company.project.jgroups;

import org.jgroups.Address;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

/**
 * 接收器
 *
 * @author wangzhj
 */
public class CustomReceiver extends ReceiverAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomReceiver.class);

    @Override
    public void receive(Message msg) {
       LOGGER.info("{}:{}", msg.getSrc(), msg.getObject());
    }

    @Override
    public void viewAccepted(View view) {
        LOGGER.info("view accepted: {}", view);
    }

    @Override
    public void suspect(Address address) {
    }

}
